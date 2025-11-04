package com.service.support.servicesupport_be_v1.service.entity;

import com.service.support.servicesupport_be_v1.exception.EmailSendException;
import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.mapper.SparePartsMapper;
import com.service.support.servicesupport_be_v1.mapper.WorksheetEntityNotesMapper;
import com.service.support.servicesupport_be_v1.mapper.WorksheetMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.*;
import com.service.support.servicesupport_be_v1.persistance.repository.*;
import com.service.support.servicesupport_be_v1.web.model.*;
import com.service.support.servicesupport_be_v1.web.model.WorksheetStatus;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class WorksheetService {

    private final WorksheetRepository worksheetRepository;
    private final WorksheetMapper worksheetMapper;
    private final WorksheetSparePartsRepository worksheetSparePartsRepository;
    private final SparePartsMapper sparePartsMapper;
    private final EmailingService mailingService;
    private final DefectRepository defectRepository;
    private final SparePartsRepository sparePartRepository;
    private final UserService userService;
    private final ToolService toolService;
    private final WorksheetEntityNotesMapper worksheetEntityNotesMapper;
    private final WorksheetNoteRepository worksheetNoteRepository;

    Double VAT =  1.27;


    public List<WorksheetEntity> getAllWorksheets() {
        return worksheetRepository.findAll();
    }

    public WorksheetEntity findById(Long id) {
        return worksheetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Worksheet not found with id: " + id));
    }

    public WorksheetEntity saveWorksheet(WorksheetEntity worksheet) {
        return worksheetRepository.save(worksheet);
    }

    public void deleteWorksheet(Long id) {
        worksheetRepository.deleteById(id);
    }

    public List<WorksheetListDto> getWorksheetList() {
        List<WorksheetEntity> entities = worksheetRepository.findAll();

        return entities.stream()
                .sorted(Comparator.comparing(WorksheetEntity::getWorksheetId).reversed())
                .map(worksheetMapper::toListDto)
                .collect(Collectors.toList());
    }

    public WorksheetEntity assignUser(Long toolId, Long userId) {
        WorksheetEntity worksheet = worksheetRepository.findById(toolId)
                .orElseThrow(() -> new ResourceNotFoundException("Worksheet not found with id " + toolId));
        UserEntity user = userService.findById(userId);
        worksheet.setAssignedUser(user);
        return worksheetRepository.save(worksheet);
    }

    public WorksheetEntity unassignUser(Long toolId) {
        WorksheetEntity worksheet = worksheetRepository.findById(toolId)
                .orElseThrow(() -> new ResourceNotFoundException("Worksheet not found with id " + toolId));
        return worksheetRepository.save(worksheet);
    }

    @Transactional()
    public WorksheetDetail getWorksheetDetails(Long id) {

        var worksheet = worksheetRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Worksheet not found with id: " + id));
        var spareparts = worksheetSparePartsRepository.findByWorksheet_WorksheetId(id);

        var detail = worksheetMapper.toDetailDto(worksheet);

        var sparepartsConverted = new ArrayList<SparePartUsage>();
        for (var sparepart : spareparts) {
            var usage = sparePartsMapper.toUsage(sparepart);
            sparepartsConverted.add(usage);
        }

        detail.setSpareParts(sparepartsConverted);
        return detail;
    }


    @Transactional
    public void updateWorksheet(Integer id, WorksheetUpdateRequest req) {

        WorksheetEntity worksheet = findById(id.longValue());

        StringBuilder changes = new StringBuilder("Munkalap változások:\n");

        // --- Egyszerű mezők ---
        if (req.getIsWarranty() != null && worksheet.isWarranty() != req.getIsWarranty()) {
            changes.append(String.format("Warranty: %s -> %s%n", worksheet.isWarranty(), req.getIsWarranty()));
            worksheet.setWarranty(req.getIsWarranty());
        }

        if (req.getHasWarrantyCard() != null && worksheet.isHasWarrantyCard() != req.getHasWarrantyCard()) {
            changes.append(String.format("WarrantyCard: %s -> %s%n", worksheet.isHasWarrantyCard(), req.getHasWarrantyCard()));
            worksheet.setHasWarrantyCard(req.getHasWarrantyCard());
        }

        if (req.getHasInvoiceCopy() != null && worksheet.isHasInvoiceCopy() != req.getHasInvoiceCopy()) {
            changes.append(String.format("InvoiceCopy: %s -> %s%n", worksheet.isHasInvoiceCopy(), req.getHasInvoiceCopy()));
            worksheet.setHasInvoiceCopy(req.getHasInvoiceCopy());
        }

        if (req.getHasRegistrationProof() != null && worksheet.isHasRegistrationProof() != req.getHasRegistrationProof()) {
            changes.append(String.format("RegistrationProof: %s -> %s%n", worksheet.isHasRegistrationProof(), req.getHasRegistrationProof()));
            worksheet.setHasRegistrationProof(req.getHasRegistrationProof());
        }

        if (req.getStatus() != null && !Objects.equals(worksheet.getStatus().toString(), req.getStatus().toString())) {
            changes.append(String.format("Status: %s -> %s%n", worksheet.getStatus(), req.getStatus()));
            worksheet.setStatus(WorksheetStatus.valueOf(req.getStatus().toString()));
        }

        if (req.getAssignee() != null) {
            Long newAssigneeId = Long.valueOf(req.getAssignee());
            Long currentAssigneeId = worksheet.getAssignedUser() != null ? worksheet.getAssignedUser().getId() : null;
            if (!Objects.equals(currentAssigneeId, newAssigneeId)) {
                changes.append(String.format("Assignee: %s -> %s%n", currentAssigneeId, newAssigneeId));
                UserEntity newUser = userService.findById(newAssigneeId);
                worksheet.setAssignedUser(newUser);
            }
        }

        // --- Defects ---
        if (req.getDefectIds() != null) {
            List<Long> currentDefectIds = worksheet.getDefects().stream()
                    .map(DefectEntity::getId)
                    .toList();
            List<Long> newDefectIds = req.getDefectIds().stream().map(Integer::longValue).toList();

            List<Long> added = newDefectIds.stream()
                    .filter(id2 -> !currentDefectIds.contains(id2))
                    .toList();
            List<Long> removed = currentDefectIds.stream()
                    .filter(id2 -> !newDefectIds.contains(id2))
                    .toList();

            if (!added.isEmpty()) {
                changes.append("Új hibák hozzáadva: ").append(added).append("\n");
                List<DefectEntity> addEntities = defectRepository.findAllById(added);
                worksheet.getDefects().addAll(addEntities);
            }
            if (!removed.isEmpty()) {
                changes.append("Hibák eltávolítva: ").append(removed).append("\n");
                worksheet.getDefects().removeIf(d -> removed.contains(d.getId()));
            }
        }

        // --- Notes ---
        if (req.getNotes() != null) {
            List<WorksheetNoteEntity> currentNotes = worksheet.getNotes();
            Map<Long, WorksheetNoteEntity> currentNoteMap = currentNotes.stream()
                    .filter(n -> n.getNoteId() != null)
                    .collect(Collectors.toMap(WorksheetNoteEntity::getNoteId, n -> n));

            for (WorksheetNote newNote : req.getNotes()) {
                if (newNote.getNoteId() == null) {
                    WorksheetNoteEntity n = new WorksheetNoteEntity();
                    n.setNoteText(newNote.getNoteText());
                    LocalDateTime postedDate = newNote.getPostedDate() != null
                            ? newNote.getPostedDate().toLocalDateTime()
                            : null;
                    n.setCreatedAt(postedDate);
                    n.setUser(userService.findById(newNote.getUserId().longValue()));
                    n.setWorksheet(worksheet);
                    worksheet.getNotes().add(n);
                    changes.append("Új note: ").append(newNote.getNoteText()).append("\n");
                    worksheetNoteRepository.save(n);
                } else if (currentNoteMap.containsKey(newNote.getNoteId())) {
                    WorksheetNoteEntity existing = currentNoteMap.get(newNote.getNoteId());
                    if (!Objects.equals(existing.getNoteText(), newNote.getNoteText())) {
                        changes.append(String.format("Note #%d módosítva: %s -> %s%n",
                                newNote.getNoteId(), existing.getNoteText(), newNote.getNoteText()));
                        existing.setNoteText(newNote.getNoteText());
                    }
                }
            }

            // törölt jegyzetek
            List<Long> newNoteIds = req.getNotes().stream()
                    .map(WorksheetNote::getNoteId)
                    .filter(Objects::nonNull)
                    .map(Long::valueOf)
                    .toList();
            List<WorksheetNoteEntity> toRemove = currentNotes.stream()
                    .filter(n -> n.getNoteId() != null && !newNoteIds.contains(n.getNoteId()))
                    .toList();
            if (!toRemove.isEmpty()) {
                changes.append("Jegyzetek törölve: ")
                        .append(toRemove.stream().map(WorksheetNoteEntity::getNoteId).toList())
                        .append("\n");
                worksheet.getNotes().removeAll(toRemove);
            }
        }

        // --- SpareParts ---
        if (req.getSpareParts() != null) {
            List<WorksheetSparePartsEntity> current = worksheet.getWorksheetSpareParts();
            Map<Long, WorksheetSparePartsEntity> currentMap = current.stream()
                    .filter(spu -> spu.getSparePart() != null)
                    .collect(Collectors.toMap(spu -> spu.getSparePart().getId(), spu -> spu));

            // hozzáadás/módosítás
            for (WorksheetSaveRequestSparePartsInner newUsage : req.getSpareParts()) {
                Long partId = newUsage.getSparePartId().longValue();
                if (currentMap.containsKey(partId)) {
                    WorksheetSparePartsEntity existing = currentMap.get(partId);
                    if (!Objects.equals(existing.getQuantity(), newUsage.getQuantity())) {
                        changes.append(String.format("SparePart %d mennyisége: %d -> %d%n",
                                partId, existing.getQuantity(), newUsage.getQuantity()));
                        existing.setQuantity(newUsage.getQuantity());
                    }
                } else {
                    SparePartsEntity part = sparePartRepository.findById(partId)
                            .orElseThrow(() -> new RuntimeException("SparePart not found"));
                    WorksheetSparePartsEntity usageEntity = new WorksheetSparePartsEntity();
                    usageEntity.setSparePart(part);
                    usageEntity.setQuantity(newUsage.getQuantity());
                    usageEntity.setWorksheet(worksheet);
                    worksheet.getWorksheetSpareParts().add(usageEntity);
                    changes.append("Új alkatrész hozzáadva: ")
                            .append(partId).append(" mennyiség: ").append(newUsage.getQuantity()).append("\n");
                }
            }

            // törlés
            List<Long> newIds = req.getSpareParts().stream()
                    .map(part -> part.getSparePartId().longValue())
                    .toList();
            List<WorksheetSparePartsEntity> toRemove = current.stream()
                    .filter(spu -> !newIds.contains(spu.getSparePart().getId()))
                    .toList();
            if (!toRemove.isEmpty()) {
                changes.append("Alkatrészek törölve: ")
                        .append(toRemove.stream().map(spu -> spu.getSparePart().getId()).toList())
                        .append("\n");
                current.removeAll(toRemove);
            }
        }

        StringBuilder html = new StringBuilder();

        html.append("<h2>Munkalap részletei</h2>");
        html.append("<table border='1' cellpadding='5' cellspacing='0' width='100%'>");

// --- Alapadatok, hibák, jegyzetek ---
        html.append("<tr><td>Munkalap azonosító</td><td>").append(worksheet.getCustomId()).append("</td></tr>")
                .append("<tr><td>Státusz</td><td>").append(worksheet.getStatus()).append("</td></tr>")
                .append("<tr><td>Felelős</td><td>").append(worksheet.getAssignedUser() != null ? worksheet.getAssignedUser().getFullName() : "N/A").append("</td></tr>")
                .append("<tr><td>Garanciás</td><td>").append(worksheet.isWarranty() ? "Igen" : "Nem").append("</td></tr>")
                .append("<tr><td>Számlamásolat</td><td>").append(worksheet.isHasInvoiceCopy() ? "Behozta" : "Nem hozta be").append("</td></tr>")
                .append("<tr><td>Regisztrációs lap</td><td>").append(worksheet.isHasRegistrationProof() ? "Behozta" : "Nem hozta be").append("</td></tr>")
                .append("<tr><td>Garancialevél</td><td>").append(worksheet.isHasWarrantyCard() ? "Behozta" : "Nem hozta be").append("</td></tr>")
                .append("<tr><td>Hiba leírása</td><td>").append(worksheet.getOwnerDescription()).append("</td></tr>");

// Hibák
        html.append("<tr><td>Hibák</td><td>");
        if (!worksheet.getDefects().isEmpty()) {
            html.append("<ul>");
            worksheet.getDefects().forEach(d -> html.append("<li>").append(d.getName()).append("</li>"));
            html.append("</ul>");
        } else {
            html.append("Nincsenek hibák");
        }
        html.append("</td></tr>");

// Jegyzetek
        html.append("<tr><td>Megjegyzések</td><td>");
        if (!worksheet.getNotes().isEmpty()) {
            html.append("<ul>");
            worksheet.getNotes().forEach(n -> {
                String user = n.getUser() != null ? n.getUser().getFullName() : "N/A";
                html.append("<li>").append(user).append(": ").append(n.getNoteText()).append("</li>");
            });
            html.append("</ul>");
        } else {
            html.append("Nincsenek jegyzetek");
        }
        html.append("</td></tr>");

// --- Alkatrészek ---
// Kitöltjük a teljes szélességet (colspan=2)
        html.append("<tr><td colspan='2'>");
        if (!worksheet.getWorksheetSpareParts().isEmpty()) {
            html.append("<table border='1' cellpadding='3' cellspacing='0' width='100%'>")
                    .append("<tr><th>Alkatrész neve</th><th>Mennyiség</th><th>Egységár</th><th>Összeg</th></tr>");
            double totalPrice = 0.0;
            for (WorksheetSparePartsEntity sp : worksheet.getWorksheetSpareParts()) {
                String name = sp.getSparePart() != null ? sp.getSparePart().getItemName() : "N/A";
                int quantity = sp.getQuantity() != 0? sp.getQuantity() : 0;
                double unitPrice = sp.getSparePart() != null ? sp.getSparePart().getNettoSellingPrice() : 0.0;
                double lineTotal = quantity * unitPrice;
                totalPrice += lineTotal;

                html.append("<tr>")
                        .append("<td>").append(name).append("</td>")
                        .append("<td>").append(quantity).append("</td>")
                        .append("<td>").append(String.format("%.0f", unitPrice)).append(" Ft</td>")
                        .append("<td>").append(String.format("%.0f", lineTotal)).append(" Ft</td>")
                        .append("</tr>");
            }

            // Összesített ár
            html.append("<tr>")
                    .append("<td colspan='3'><strong>Összesen nettó</strong></td>")
                    .append("<td><strong>").append(String.format("%.0f", totalPrice)).append(" Ft</strong></td>")
                    .append("</tr>")
                    .append("<tr>")
                    .append("<td colspan='3'><strong>Összesen bruttó</strong></td>")
                    .append("<td><strong>").append(String.format("%.0f", totalPrice * VAT)).append(" Ft</strong></td>")
                    .append("</tr>");

            html.append("</table>");
        } else {
            html.append("Nincsenek alkatrészek");
        }
        html.append("</td></tr>");

        html.append("</table>");






        if (changes.length() > "Javítási munkalap változások - Szerszám Kuckó Kft\n".length()) {
            mailingService.sendNotification(html.toString());
            try {
                mailingService.sendHtmlEmail(worksheet.getTool().getOwner().getEmail(), "Módosítás történt", html.toString());
            } catch (MessagingException e) {
                throw new EmailSendException("Email küldés sikertelen", e);
            }
        }


        worksheetRepository.save(worksheet);
    }



    @Transactional
    public WorksheetEntity createWorksheet(WorksheetCreateRequest worksheetCreateRequest) {

        LocalDate today = LocalDate.now();
        int year = today.getYear() % 100;
        int month = today.getMonthValue();

        String prefix = String.format("%02d%02d/", year, month);
        long recordsInMonth = worksheetRepository.countByCustomIdStartingWith(prefix);

        WorksheetEntity worksheet = WorksheetEntity.builder()
                .defects(
                        defectRepository.findAllById(
                                worksheetCreateRequest.getDefectIds()
                                        .stream()
                                        .map(Long::valueOf)
                                        .toList()
                        )
                )
                .assignedUser(userService.findById(worksheetCreateRequest.getAssignee()))
                .customId(prefix + (recordsInMonth + 1))
                .hasInvoiceCopy(worksheetCreateRequest.getHasInvoiceCopy())
                .hasRegistrationProof(worksheetCreateRequest.getHasRegistrationProof())
                .hasWarrantyCard(worksheetCreateRequest.getHasWarrantyCard())
                .warranty(worksheetCreateRequest.getIsWarranty())
                .ownerDescription(worksheetCreateRequest.getOwnerDescription())
                .status(WorksheetStatus.valueOf(worksheetCreateRequest.getStatus().toString()))
                .tool(toolService.findById(worksheetCreateRequest.getToolId().longValue()))
                .build();

        worksheetRepository.save(worksheet);
        List<WorksheetNoteEntity> worksheetNoteEntities = new ArrayList<>();
                for(var note : worksheetCreateRequest.getNotes()) {
                    var NoteEntity = worksheetEntityNotesMapper.toEntity(note , worksheet);
                    worksheetNoteEntities.add(NoteEntity);
                }
                worksheetNoteRepository.saveAll(worksheetNoteEntities);
        return worksheet;
    }
}


package com.service.support.servicesupport_be_v1.mapper;


import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetEntity;
import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetNoteEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.UserRepository;
import com.service.support.servicesupport_be_v1.web.model.Worksheet;
import com.service.support.servicesupport_be_v1.web.model.WorksheetNote;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class WorksheetEntityNotesMapper {
    private  final UserRepository userRepository;

   public WorksheetNoteEntity toEntity(WorksheetNote worksheetNote, WorksheetEntity worksheet) {

        return WorksheetNoteEntity.builder()
                .noteText(worksheetNote.getNoteText())
                .user(userRepository.findById(worksheetNote.getUserId().longValue()).get())
                .worksheet(worksheet)
                .build();
    }
}

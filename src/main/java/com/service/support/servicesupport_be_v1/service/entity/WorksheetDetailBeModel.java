package com.service.support.servicesupport_be_v1.service.entity;

import com.service.support.servicesupport_be_v1.web.model.*;

import java.time.OffsetDateTime;
import java.util.List;

public class WorksheetDetailBeModel {
    private Long worksheetId;

    private WorksheetStatus status;

    private Boolean isWarranty;

    private Boolean hasWarrantyCard;

    private Boolean hasInvoiceCopy;

    private Boolean hasRegistrationProof;

    private OffsetDateTime createdAt;

    private String ownerDescription;

    private Tool tool;

    private List<Defect> defects;

    private List<WorksheetNote> notes;

    private List<SparePartUsage> spareParts;

    private UserSummary assignedUser;
}

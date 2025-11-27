package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.service.support.servicesupport_be_v1.web.model.Defect;
import com.service.support.servicesupport_be_v1.web.model.SparePartUsage;
import com.service.support.servicesupport_be_v1.web.model.Tool;
import com.service.support.servicesupport_be_v1.web.model.UserSummary;
import com.service.support.servicesupport_be_v1.web.model.WorksheetNote;
import com.service.support.servicesupport_be_v1.web.model.WorksheetStatus;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * WorksheetDetail
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-28T00:56:50.465067900+01:00[Europe/Budapest]")
public class WorksheetDetail {

  private Long worksheetId;

  private WorksheetStatus status;

  private Boolean isWarranty;

  private Boolean hasWarrantyCard;

  private Boolean hasInvoiceCopy;

  private Boolean hasRegistrationProof;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  private String ownerDescription;

  private Tool tool;

  @Valid
  private List<@Valid Defect> defects;

  @Valid
  private List<@Valid WorksheetNote> notes;

  @Valid
  private List<@Valid SparePartUsage> spareParts;

  private UserSummary assignedUser;

  public WorksheetDetail worksheetId(Long worksheetId) {
    this.worksheetId = worksheetId;
    return this;
  }

  /**
   * Get worksheetId
   * @return worksheetId
  */
  
  @Schema(name = "worksheetId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("worksheetId")
  public Long getWorksheetId() {
    return worksheetId;
  }

  public void setWorksheetId(Long worksheetId) {
    this.worksheetId = worksheetId;
  }

  public WorksheetDetail status(WorksheetStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public WorksheetStatus getStatus() {
    return status;
  }

  public void setStatus(WorksheetStatus status) {
    this.status = status;
  }

  public WorksheetDetail isWarranty(Boolean isWarranty) {
    this.isWarranty = isWarranty;
    return this;
  }

  /**
   * Get isWarranty
   * @return isWarranty
  */
  
  @Schema(name = "isWarranty", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isWarranty")
  public Boolean getIsWarranty() {
    return isWarranty;
  }

  public void setIsWarranty(Boolean isWarranty) {
    this.isWarranty = isWarranty;
  }

  public WorksheetDetail hasWarrantyCard(Boolean hasWarrantyCard) {
    this.hasWarrantyCard = hasWarrantyCard;
    return this;
  }

  /**
   * Get hasWarrantyCard
   * @return hasWarrantyCard
  */
  
  @Schema(name = "hasWarrantyCard", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hasWarrantyCard")
  public Boolean getHasWarrantyCard() {
    return hasWarrantyCard;
  }

  public void setHasWarrantyCard(Boolean hasWarrantyCard) {
    this.hasWarrantyCard = hasWarrantyCard;
  }

  public WorksheetDetail hasInvoiceCopy(Boolean hasInvoiceCopy) {
    this.hasInvoiceCopy = hasInvoiceCopy;
    return this;
  }

  /**
   * Get hasInvoiceCopy
   * @return hasInvoiceCopy
  */
  
  @Schema(name = "hasInvoiceCopy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hasInvoiceCopy")
  public Boolean getHasInvoiceCopy() {
    return hasInvoiceCopy;
  }

  public void setHasInvoiceCopy(Boolean hasInvoiceCopy) {
    this.hasInvoiceCopy = hasInvoiceCopy;
  }

  public WorksheetDetail hasRegistrationProof(Boolean hasRegistrationProof) {
    this.hasRegistrationProof = hasRegistrationProof;
    return this;
  }

  /**
   * Get hasRegistrationProof
   * @return hasRegistrationProof
  */
  
  @Schema(name = "hasRegistrationProof", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hasRegistrationProof")
  public Boolean getHasRegistrationProof() {
    return hasRegistrationProof;
  }

  public void setHasRegistrationProof(Boolean hasRegistrationProof) {
    this.hasRegistrationProof = hasRegistrationProof;
  }

  public WorksheetDetail createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  */
  @Valid 
  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public WorksheetDetail ownerDescription(String ownerDescription) {
    this.ownerDescription = ownerDescription;
    return this;
  }

  /**
   * Get ownerDescription
   * @return ownerDescription
  */
  
  @Schema(name = "ownerDescription", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ownerDescription")
  public String getOwnerDescription() {
    return ownerDescription;
  }

  public void setOwnerDescription(String ownerDescription) {
    this.ownerDescription = ownerDescription;
  }

  public WorksheetDetail tool(Tool tool) {
    this.tool = tool;
    return this;
  }

  /**
   * Get tool
   * @return tool
  */
  @Valid 
  @Schema(name = "tool", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tool")
  public Tool getTool() {
    return tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public WorksheetDetail defects(List<@Valid Defect> defects) {
    this.defects = defects;
    return this;
  }

  public WorksheetDetail addDefectsItem(Defect defectsItem) {
    if (this.defects == null) {
      this.defects = new ArrayList<>();
    }
    this.defects.add(defectsItem);
    return this;
  }

  /**
   * Get defects
   * @return defects
  */
  @Valid 
  @Schema(name = "defects", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("defects")
  public List<@Valid Defect> getDefects() {
    return defects;
  }

  public void setDefects(List<@Valid Defect> defects) {
    this.defects = defects;
  }

  public WorksheetDetail notes(List<@Valid WorksheetNote> notes) {
    this.notes = notes;
    return this;
  }

  public WorksheetDetail addNotesItem(WorksheetNote notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Get notes
   * @return notes
  */
  @Valid 
  @Schema(name = "notes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("notes")
  public List<@Valid WorksheetNote> getNotes() {
    return notes;
  }

  public void setNotes(List<@Valid WorksheetNote> notes) {
    this.notes = notes;
  }

  public WorksheetDetail spareParts(List<@Valid SparePartUsage> spareParts) {
    this.spareParts = spareParts;
    return this;
  }

  public WorksheetDetail addSparePartsItem(SparePartUsage sparePartsItem) {
    if (this.spareParts == null) {
      this.spareParts = new ArrayList<>();
    }
    this.spareParts.add(sparePartsItem);
    return this;
  }

  /**
   * Get spareParts
   * @return spareParts
  */
  @Valid 
  @Schema(name = "spareParts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("spareParts")
  public List<@Valid SparePartUsage> getSpareParts() {
    return spareParts;
  }

  public void setSpareParts(List<@Valid SparePartUsage> spareParts) {
    this.spareParts = spareParts;
  }

  public WorksheetDetail assignedUser(UserSummary assignedUser) {
    this.assignedUser = assignedUser;
    return this;
  }

  /**
   * Get assignedUser
   * @return assignedUser
  */
  @Valid 
  @Schema(name = "assignedUser", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assignedUser")
  public UserSummary getAssignedUser() {
    return assignedUser;
  }

  public void setAssignedUser(UserSummary assignedUser) {
    this.assignedUser = assignedUser;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorksheetDetail worksheetDetail = (WorksheetDetail) o;
    return Objects.equals(this.worksheetId, worksheetDetail.worksheetId) &&
        Objects.equals(this.status, worksheetDetail.status) &&
        Objects.equals(this.isWarranty, worksheetDetail.isWarranty) &&
        Objects.equals(this.hasWarrantyCard, worksheetDetail.hasWarrantyCard) &&
        Objects.equals(this.hasInvoiceCopy, worksheetDetail.hasInvoiceCopy) &&
        Objects.equals(this.hasRegistrationProof, worksheetDetail.hasRegistrationProof) &&
        Objects.equals(this.createdAt, worksheetDetail.createdAt) &&
        Objects.equals(this.ownerDescription, worksheetDetail.ownerDescription) &&
        Objects.equals(this.tool, worksheetDetail.tool) &&
        Objects.equals(this.defects, worksheetDetail.defects) &&
        Objects.equals(this.notes, worksheetDetail.notes) &&
        Objects.equals(this.spareParts, worksheetDetail.spareParts) &&
        Objects.equals(this.assignedUser, worksheetDetail.assignedUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(worksheetId, status, isWarranty, hasWarrantyCard, hasInvoiceCopy, hasRegistrationProof, createdAt, ownerDescription, tool, defects, notes, spareParts, assignedUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorksheetDetail {\n");
    sb.append("    worksheetId: ").append(toIndentedString(worksheetId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    isWarranty: ").append(toIndentedString(isWarranty)).append("\n");
    sb.append("    hasWarrantyCard: ").append(toIndentedString(hasWarrantyCard)).append("\n");
    sb.append("    hasInvoiceCopy: ").append(toIndentedString(hasInvoiceCopy)).append("\n");
    sb.append("    hasRegistrationProof: ").append(toIndentedString(hasRegistrationProof)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    ownerDescription: ").append(toIndentedString(ownerDescription)).append("\n");
    sb.append("    tool: ").append(toIndentedString(tool)).append("\n");
    sb.append("    defects: ").append(toIndentedString(defects)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    spareParts: ").append(toIndentedString(spareParts)).append("\n");
    sb.append("    assignedUser: ").append(toIndentedString(assignedUser)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


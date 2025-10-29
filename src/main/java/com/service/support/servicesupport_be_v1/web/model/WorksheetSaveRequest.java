package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.service.support.servicesupport_be_v1.web.model.WorksheetNote;
import com.service.support.servicesupport_be_v1.web.model.WorksheetSaveRequestSparePartsInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * WorksheetSaveRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-29T19:08:40.422899500+01:00[Europe/Budapest]")
public class WorksheetSaveRequest {

  private Integer toolId;

  @Valid
  private List<Integer> defectIds = new ArrayList<>();

  @Valid
  private List<@Valid WorksheetNote> notes = new ArrayList<>();

  private Boolean isWarranty;

  private Boolean hasWarrantyCard;

  private Boolean hasInvoiceCopy;

  private Boolean hasRegistrationProof;

  private Integer assignee;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    BEERKEZETT("BEERKEZETT"),
    
    FOLYAMATBAN("FOLYAMATBAN"),
    
    FELKULDVE("FELKULDVE"),
    
    VISSZAERKEZETT("VISSZAERKEZETT"),
    
    KIAJANLOTT("KIAJANLOTT"),
    
    ELFOGADVA("ELFOGADVA"),
    
    KIERTESTVE("KIERTESTVE"),
    
    LEZART("LEZART");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  @Valid
  private List<@Valid WorksheetSaveRequestSparePartsInner> spareParts = new ArrayList<>();

  public WorksheetSaveRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public WorksheetSaveRequest(Integer toolId, List<Integer> defectIds, List<@Valid WorksheetNote> notes, Boolean isWarranty, Boolean hasWarrantyCard, Boolean hasInvoiceCopy, Boolean hasRegistrationProof, StatusEnum status, List<@Valid WorksheetSaveRequestSparePartsInner> spareParts) {
    this.toolId = toolId;
    this.defectIds = defectIds;
    this.notes = notes;
    this.isWarranty = isWarranty;
    this.hasWarrantyCard = hasWarrantyCard;
    this.hasInvoiceCopy = hasInvoiceCopy;
    this.hasRegistrationProof = hasRegistrationProof;
    this.status = status;
    this.spareParts = spareParts;
  }

  public WorksheetSaveRequest toolId(Integer toolId) {
    this.toolId = toolId;
    return this;
  }

  /**
   * Get toolId
   * @return toolId
  */
  @NotNull 
  @Schema(name = "toolId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("toolId")
  public Integer getToolId() {
    return toolId;
  }

  public void setToolId(Integer toolId) {
    this.toolId = toolId;
  }

  public WorksheetSaveRequest defectIds(List<Integer> defectIds) {
    this.defectIds = defectIds;
    return this;
  }

  public WorksheetSaveRequest addDefectIdsItem(Integer defectIdsItem) {
    if (this.defectIds == null) {
      this.defectIds = new ArrayList<>();
    }
    this.defectIds.add(defectIdsItem);
    return this;
  }

  /**
   * Get defectIds
   * @return defectIds
  */
  @NotNull 
  @Schema(name = "defectIds", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("defectIds")
  public List<Integer> getDefectIds() {
    return defectIds;
  }

  public void setDefectIds(List<Integer> defectIds) {
    this.defectIds = defectIds;
  }

  public WorksheetSaveRequest notes(List<@Valid WorksheetNote> notes) {
    this.notes = notes;
    return this;
  }

  public WorksheetSaveRequest addNotesItem(WorksheetNote notesItem) {
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
  @NotNull @Valid 
  @Schema(name = "notes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("notes")
  public List<@Valid WorksheetNote> getNotes() {
    return notes;
  }

  public void setNotes(List<@Valid WorksheetNote> notes) {
    this.notes = notes;
  }

  public WorksheetSaveRequest isWarranty(Boolean isWarranty) {
    this.isWarranty = isWarranty;
    return this;
  }

  /**
   * Get isWarranty
   * @return isWarranty
  */
  @NotNull 
  @Schema(name = "isWarranty", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isWarranty")
  public Boolean getIsWarranty() {
    return isWarranty;
  }

  public void setIsWarranty(Boolean isWarranty) {
    this.isWarranty = isWarranty;
  }

  public WorksheetSaveRequest hasWarrantyCard(Boolean hasWarrantyCard) {
    this.hasWarrantyCard = hasWarrantyCard;
    return this;
  }

  /**
   * Get hasWarrantyCard
   * @return hasWarrantyCard
  */
  @NotNull 
  @Schema(name = "hasWarrantyCard", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hasWarrantyCard")
  public Boolean getHasWarrantyCard() {
    return hasWarrantyCard;
  }

  public void setHasWarrantyCard(Boolean hasWarrantyCard) {
    this.hasWarrantyCard = hasWarrantyCard;
  }

  public WorksheetSaveRequest hasInvoiceCopy(Boolean hasInvoiceCopy) {
    this.hasInvoiceCopy = hasInvoiceCopy;
    return this;
  }

  /**
   * Get hasInvoiceCopy
   * @return hasInvoiceCopy
  */
  @NotNull 
  @Schema(name = "hasInvoiceCopy", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hasInvoiceCopy")
  public Boolean getHasInvoiceCopy() {
    return hasInvoiceCopy;
  }

  public void setHasInvoiceCopy(Boolean hasInvoiceCopy) {
    this.hasInvoiceCopy = hasInvoiceCopy;
  }

  public WorksheetSaveRequest hasRegistrationProof(Boolean hasRegistrationProof) {
    this.hasRegistrationProof = hasRegistrationProof;
    return this;
  }

  /**
   * Get hasRegistrationProof
   * @return hasRegistrationProof
  */
  @NotNull 
  @Schema(name = "hasRegistrationProof", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hasRegistrationProof")
  public Boolean getHasRegistrationProof() {
    return hasRegistrationProof;
  }

  public void setHasRegistrationProof(Boolean hasRegistrationProof) {
    this.hasRegistrationProof = hasRegistrationProof;
  }

  public WorksheetSaveRequest assignee(Integer assignee) {
    this.assignee = assignee;
    return this;
  }

  /**
   * Get assignee
   * @return assignee
  */
  
  @Schema(name = "assignee", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assignee")
  public Integer getAssignee() {
    return assignee;
  }

  public void setAssignee(Integer assignee) {
    this.assignee = assignee;
  }

  public WorksheetSaveRequest status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public WorksheetSaveRequest spareParts(List<@Valid WorksheetSaveRequestSparePartsInner> spareParts) {
    this.spareParts = spareParts;
    return this;
  }

  public WorksheetSaveRequest addSparePartsItem(WorksheetSaveRequestSparePartsInner sparePartsItem) {
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
  @NotNull @Valid 
  @Schema(name = "spareParts", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("spareParts")
  public List<@Valid WorksheetSaveRequestSparePartsInner> getSpareParts() {
    return spareParts;
  }

  public void setSpareParts(List<@Valid WorksheetSaveRequestSparePartsInner> spareParts) {
    this.spareParts = spareParts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorksheetSaveRequest worksheetSaveRequest = (WorksheetSaveRequest) o;
    return Objects.equals(this.toolId, worksheetSaveRequest.toolId) &&
        Objects.equals(this.defectIds, worksheetSaveRequest.defectIds) &&
        Objects.equals(this.notes, worksheetSaveRequest.notes) &&
        Objects.equals(this.isWarranty, worksheetSaveRequest.isWarranty) &&
        Objects.equals(this.hasWarrantyCard, worksheetSaveRequest.hasWarrantyCard) &&
        Objects.equals(this.hasInvoiceCopy, worksheetSaveRequest.hasInvoiceCopy) &&
        Objects.equals(this.hasRegistrationProof, worksheetSaveRequest.hasRegistrationProof) &&
        Objects.equals(this.assignee, worksheetSaveRequest.assignee) &&
        Objects.equals(this.status, worksheetSaveRequest.status) &&
        Objects.equals(this.spareParts, worksheetSaveRequest.spareParts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(toolId, defectIds, notes, isWarranty, hasWarrantyCard, hasInvoiceCopy, hasRegistrationProof, assignee, status, spareParts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorksheetSaveRequest {\n");
    sb.append("    toolId: ").append(toIndentedString(toolId)).append("\n");
    sb.append("    defectIds: ").append(toIndentedString(defectIds)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    isWarranty: ").append(toIndentedString(isWarranty)).append("\n");
    sb.append("    hasWarrantyCard: ").append(toIndentedString(hasWarrantyCard)).append("\n");
    sb.append("    hasInvoiceCopy: ").append(toIndentedString(hasInvoiceCopy)).append("\n");
    sb.append("    hasRegistrationProof: ").append(toIndentedString(hasRegistrationProof)).append("\n");
    sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    spareParts: ").append(toIndentedString(spareParts)).append("\n");
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


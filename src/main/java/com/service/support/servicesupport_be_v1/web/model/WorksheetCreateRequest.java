package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.service.support.servicesupport_be_v1.web.model.WorksheetNote;
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
 * WorksheetCreateRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-19T09:21:19.884147+01:00[Europe/Budapest]")
public class WorksheetCreateRequest {

  @Valid
  private List<@Valid WorksheetNote> notes = new ArrayList<>();

  @Valid
  private List<Integer> defectIds;

  private Integer toolId;

  private Boolean isWarranty;

  private Boolean hasWarrantyCard;

  private Boolean hasInvoiceCopy;

  private Boolean hasRegistrationProof;

  private String ownerDescription;

  private Integer assignee;

  /**
   * Munkalap státusza
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

  public WorksheetCreateRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public WorksheetCreateRequest(List<@Valid WorksheetNote> notes, Integer toolId, Boolean isWarranty, Boolean hasWarrantyCard, Boolean hasInvoiceCopy, Boolean hasRegistrationProof, Integer assignee, StatusEnum status) {
    this.notes = notes;
    this.toolId = toolId;
    this.isWarranty = isWarranty;
    this.hasWarrantyCard = hasWarrantyCard;
    this.hasInvoiceCopy = hasInvoiceCopy;
    this.hasRegistrationProof = hasRegistrationProof;
    this.assignee = assignee;
    this.status = status;
  }

  public WorksheetCreateRequest notes(List<@Valid WorksheetNote> notes) {
    this.notes = notes;
    return this;
  }

  public WorksheetCreateRequest addNotesItem(WorksheetNote notesItem) {
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

  public WorksheetCreateRequest defectIds(List<Integer> defectIds) {
    this.defectIds = defectIds;
    return this;
  }

  public WorksheetCreateRequest addDefectIdsItem(Integer defectIdsItem) {
    if (this.defectIds == null) {
      this.defectIds = new ArrayList<>();
    }
    this.defectIds.add(defectIdsItem);
    return this;
  }

  /**
   * A hibák azonosítói
   * @return defectIds
  */
  
  @Schema(name = "defectIds", description = "A hibák azonosítói", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("defectIds")
  public List<Integer> getDefectIds() {
    return defectIds;
  }

  public void setDefectIds(List<Integer> defectIds) {
    this.defectIds = defectIds;
  }

  public WorksheetCreateRequest toolId(Integer toolId) {
    this.toolId = toolId;
    return this;
  }

  /**
   * A gép azonosítója
   * @return toolId
  */
  @NotNull 
  @Schema(name = "toolId", example = "2", description = "A gép azonosítója", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("toolId")
  public Integer getToolId() {
    return toolId;
  }

  public void setToolId(Integer toolId) {
    this.toolId = toolId;
  }

  public WorksheetCreateRequest isWarranty(Boolean isWarranty) {
    this.isWarranty = isWarranty;
    return this;
  }

  /**
   * Garanciális-e
   * @return isWarranty
  */
  @NotNull 
  @Schema(name = "isWarranty", example = "true", description = "Garanciális-e", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isWarranty")
  public Boolean getIsWarranty() {
    return isWarranty;
  }

  public void setIsWarranty(Boolean isWarranty) {
    this.isWarranty = isWarranty;
  }

  public WorksheetCreateRequest hasWarrantyCard(Boolean hasWarrantyCard) {
    this.hasWarrantyCard = hasWarrantyCard;
    return this;
  }

  /**
   * Van-e jótállási kártya
   * @return hasWarrantyCard
  */
  @NotNull 
  @Schema(name = "hasWarrantyCard", example = "false", description = "Van-e jótállási kártya", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hasWarrantyCard")
  public Boolean getHasWarrantyCard() {
    return hasWarrantyCard;
  }

  public void setHasWarrantyCard(Boolean hasWarrantyCard) {
    this.hasWarrantyCard = hasWarrantyCard;
  }

  public WorksheetCreateRequest hasInvoiceCopy(Boolean hasInvoiceCopy) {
    this.hasInvoiceCopy = hasInvoiceCopy;
    return this;
  }

  /**
   * Van-e számlamásolat
   * @return hasInvoiceCopy
  */
  @NotNull 
  @Schema(name = "hasInvoiceCopy", example = "true", description = "Van-e számlamásolat", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hasInvoiceCopy")
  public Boolean getHasInvoiceCopy() {
    return hasInvoiceCopy;
  }

  public void setHasInvoiceCopy(Boolean hasInvoiceCopy) {
    this.hasInvoiceCopy = hasInvoiceCopy;
  }

  public WorksheetCreateRequest hasRegistrationProof(Boolean hasRegistrationProof) {
    this.hasRegistrationProof = hasRegistrationProof;
    return this;
  }

  /**
   * Van-e regisztrációs igazolás
   * @return hasRegistrationProof
  */
  @NotNull 
  @Schema(name = "hasRegistrationProof", example = "false", description = "Van-e regisztrációs igazolás", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hasRegistrationProof")
  public Boolean getHasRegistrationProof() {
    return hasRegistrationProof;
  }

  public void setHasRegistrationProof(Boolean hasRegistrationProof) {
    this.hasRegistrationProof = hasRegistrationProof;
  }

  public WorksheetCreateRequest ownerDescription(String ownerDescription) {
    this.ownerDescription = ownerDescription;
    return this;
  }

  /**
   * Tulajdonos által megadott leírás
   * @return ownerDescription
  */
  
  @Schema(name = "ownerDescription", example = "asd", description = "Tulajdonos által megadott leírás", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ownerDescription")
  public String getOwnerDescription() {
    return ownerDescription;
  }

  public void setOwnerDescription(String ownerDescription) {
    this.ownerDescription = ownerDescription;
  }

  public WorksheetCreateRequest assignee(Integer assignee) {
    this.assignee = assignee;
    return this;
  }

  /**
   * A hozzárendelt szerelő ID-je
   * @return assignee
  */
  @NotNull 
  @Schema(name = "assignee", example = "2", description = "A hozzárendelt szerelő ID-je", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("assignee")
  public Integer getAssignee() {
    return assignee;
  }

  public void setAssignee(Integer assignee) {
    this.assignee = assignee;
  }

  public WorksheetCreateRequest status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Munkalap státusza
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "BEERKEZETT", description = "Munkalap státusza", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorksheetCreateRequest worksheetCreateRequest = (WorksheetCreateRequest) o;
    return Objects.equals(this.notes, worksheetCreateRequest.notes) &&
        Objects.equals(this.defectIds, worksheetCreateRequest.defectIds) &&
        Objects.equals(this.toolId, worksheetCreateRequest.toolId) &&
        Objects.equals(this.isWarranty, worksheetCreateRequest.isWarranty) &&
        Objects.equals(this.hasWarrantyCard, worksheetCreateRequest.hasWarrantyCard) &&
        Objects.equals(this.hasInvoiceCopy, worksheetCreateRequest.hasInvoiceCopy) &&
        Objects.equals(this.hasRegistrationProof, worksheetCreateRequest.hasRegistrationProof) &&
        Objects.equals(this.ownerDescription, worksheetCreateRequest.ownerDescription) &&
        Objects.equals(this.assignee, worksheetCreateRequest.assignee) &&
        Objects.equals(this.status, worksheetCreateRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notes, defectIds, toolId, isWarranty, hasWarrantyCard, hasInvoiceCopy, hasRegistrationProof, ownerDescription, assignee, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorksheetCreateRequest {\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    defectIds: ").append(toIndentedString(defectIds)).append("\n");
    sb.append("    toolId: ").append(toIndentedString(toolId)).append("\n");
    sb.append("    isWarranty: ").append(toIndentedString(isWarranty)).append("\n");
    sb.append("    hasWarrantyCard: ").append(toIndentedString(hasWarrantyCard)).append("\n");
    sb.append("    hasInvoiceCopy: ").append(toIndentedString(hasInvoiceCopy)).append("\n");
    sb.append("    hasRegistrationProof: ").append(toIndentedString(hasRegistrationProof)).append("\n");
    sb.append("    ownerDescription: ").append(toIndentedString(ownerDescription)).append("\n");
    sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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


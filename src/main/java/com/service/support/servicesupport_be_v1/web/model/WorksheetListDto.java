package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.service.support.servicesupport_be_v1.web.model.WorksheetStatus;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * WorksheetListDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-26T00:50:01.219711400+01:00[Europe/Budapest]")
public class WorksheetListDto {

  private Long worksheetId;

  private String customId;

  private Long toolId;

  private String toolItemNumber;

  private String toolSerialNumber;

  private String ownerCompanyName;

  private String ownerCompanyEmployeeName;

  private String assignedUserFullName;

  private WorksheetStatus status;

  public WorksheetListDto worksheetId(Long worksheetId) {
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

  public WorksheetListDto customId(String customId) {
    this.customId = customId;
    return this;
  }

  /**
   * Get customId
   * @return customId
  */
  
  @Schema(name = "customId", example = "2501/1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customId")
  public String getCustomId() {
    return customId;
  }

  public void setCustomId(String customId) {
    this.customId = customId;
  }

  public WorksheetListDto toolId(Long toolId) {
    this.toolId = toolId;
    return this;
  }

  /**
   * Get toolId
   * @return toolId
  */
  
  @Schema(name = "toolId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("toolId")
  public Long getToolId() {
    return toolId;
  }

  public void setToolId(Long toolId) {
    this.toolId = toolId;
  }

  public WorksheetListDto toolItemNumber(String toolItemNumber) {
    this.toolItemNumber = toolItemNumber;
    return this;
  }

  /**
   * Get toolItemNumber
   * @return toolItemNumber
  */
  
  @Schema(name = "toolItemNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("toolItemNumber")
  public String getToolItemNumber() {
    return toolItemNumber;
  }

  public void setToolItemNumber(String toolItemNumber) {
    this.toolItemNumber = toolItemNumber;
  }

  public WorksheetListDto toolSerialNumber(String toolSerialNumber) {
    this.toolSerialNumber = toolSerialNumber;
    return this;
  }

  /**
   * Get toolSerialNumber
   * @return toolSerialNumber
  */
  
  @Schema(name = "toolSerialNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("toolSerialNumber")
  public String getToolSerialNumber() {
    return toolSerialNumber;
  }

  public void setToolSerialNumber(String toolSerialNumber) {
    this.toolSerialNumber = toolSerialNumber;
  }

  public WorksheetListDto ownerCompanyName(String ownerCompanyName) {
    this.ownerCompanyName = ownerCompanyName;
    return this;
  }

  /**
   * Get ownerCompanyName
   * @return ownerCompanyName
  */
  
  @Schema(name = "ownerCompanyName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ownerCompanyName")
  public String getOwnerCompanyName() {
    return ownerCompanyName;
  }

  public void setOwnerCompanyName(String ownerCompanyName) {
    this.ownerCompanyName = ownerCompanyName;
  }

  public WorksheetListDto ownerCompanyEmployeeName(String ownerCompanyEmployeeName) {
    this.ownerCompanyEmployeeName = ownerCompanyEmployeeName;
    return this;
  }

  /**
   * Get ownerCompanyEmployeeName
   * @return ownerCompanyEmployeeName
  */
  
  @Schema(name = "ownerCompanyEmployeeName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ownerCompanyEmployeeName")
  public String getOwnerCompanyEmployeeName() {
    return ownerCompanyEmployeeName;
  }

  public void setOwnerCompanyEmployeeName(String ownerCompanyEmployeeName) {
    this.ownerCompanyEmployeeName = ownerCompanyEmployeeName;
  }

  public WorksheetListDto assignedUserFullName(String assignedUserFullName) {
    this.assignedUserFullName = assignedUserFullName;
    return this;
  }

  /**
   * Get assignedUserFullName
   * @return assignedUserFullName
  */
  
  @Schema(name = "assignedUserFullName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assignedUserFullName")
  public String getAssignedUserFullName() {
    return assignedUserFullName;
  }

  public void setAssignedUserFullName(String assignedUserFullName) {
    this.assignedUserFullName = assignedUserFullName;
  }

  public WorksheetListDto status(WorksheetStatus status) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorksheetListDto worksheetListDto = (WorksheetListDto) o;
    return Objects.equals(this.worksheetId, worksheetListDto.worksheetId) &&
        Objects.equals(this.customId, worksheetListDto.customId) &&
        Objects.equals(this.toolId, worksheetListDto.toolId) &&
        Objects.equals(this.toolItemNumber, worksheetListDto.toolItemNumber) &&
        Objects.equals(this.toolSerialNumber, worksheetListDto.toolSerialNumber) &&
        Objects.equals(this.ownerCompanyName, worksheetListDto.ownerCompanyName) &&
        Objects.equals(this.ownerCompanyEmployeeName, worksheetListDto.ownerCompanyEmployeeName) &&
        Objects.equals(this.assignedUserFullName, worksheetListDto.assignedUserFullName) &&
        Objects.equals(this.status, worksheetListDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(worksheetId, customId, toolId, toolItemNumber, toolSerialNumber, ownerCompanyName, ownerCompanyEmployeeName, assignedUserFullName, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorksheetListDto {\n");
    sb.append("    worksheetId: ").append(toIndentedString(worksheetId)).append("\n");
    sb.append("    customId: ").append(toIndentedString(customId)).append("\n");
    sb.append("    toolId: ").append(toIndentedString(toolId)).append("\n");
    sb.append("    toolItemNumber: ").append(toIndentedString(toolItemNumber)).append("\n");
    sb.append("    toolSerialNumber: ").append(toIndentedString(toolSerialNumber)).append("\n");
    sb.append("    ownerCompanyName: ").append(toIndentedString(ownerCompanyName)).append("\n");
    sb.append("    ownerCompanyEmployeeName: ").append(toIndentedString(ownerCompanyEmployeeName)).append("\n");
    sb.append("    assignedUserFullName: ").append(toIndentedString(assignedUserFullName)).append("\n");
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


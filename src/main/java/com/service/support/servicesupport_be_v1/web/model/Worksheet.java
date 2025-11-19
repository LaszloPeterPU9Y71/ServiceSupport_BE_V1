package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Worksheet
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-19T09:21:19.884147+01:00[Europe/Budapest]")
public class Worksheet {

  private Integer id;

  private String customId;

  private Integer toolId;

  private Boolean isWarranty;

  private Boolean hasWarrantyCard;

  private Boolean hasInvoiceCopy;

  private Boolean hasRegistrationProof;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  public Worksheet() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Worksheet(Integer toolId) {
    this.toolId = toolId;
  }

  public Worksheet id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Worksheet customId(String customId) {
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

  public Worksheet toolId(Integer toolId) {
    this.toolId = toolId;
    return this;
  }

  /**
   * Get toolId
   * @return toolId
  */
  @NotNull 
  @Schema(name = "toolId", example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("toolId")
  public Integer getToolId() {
    return toolId;
  }

  public void setToolId(Integer toolId) {
    this.toolId = toolId;
  }

  public Worksheet isWarranty(Boolean isWarranty) {
    this.isWarranty = isWarranty;
    return this;
  }

  /**
   * Get isWarranty
   * @return isWarranty
  */
  
  @Schema(name = "isWarranty", example = "true", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isWarranty")
  public Boolean getIsWarranty() {
    return isWarranty;
  }

  public void setIsWarranty(Boolean isWarranty) {
    this.isWarranty = isWarranty;
  }

  public Worksheet hasWarrantyCard(Boolean hasWarrantyCard) {
    this.hasWarrantyCard = hasWarrantyCard;
    return this;
  }

  /**
   * Get hasWarrantyCard
   * @return hasWarrantyCard
  */
  
  @Schema(name = "hasWarrantyCard", example = "true", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hasWarrantyCard")
  public Boolean getHasWarrantyCard() {
    return hasWarrantyCard;
  }

  public void setHasWarrantyCard(Boolean hasWarrantyCard) {
    this.hasWarrantyCard = hasWarrantyCard;
  }

  public Worksheet hasInvoiceCopy(Boolean hasInvoiceCopy) {
    this.hasInvoiceCopy = hasInvoiceCopy;
    return this;
  }

  /**
   * Get hasInvoiceCopy
   * @return hasInvoiceCopy
  */
  
  @Schema(name = "hasInvoiceCopy", example = "false", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hasInvoiceCopy")
  public Boolean getHasInvoiceCopy() {
    return hasInvoiceCopy;
  }

  public void setHasInvoiceCopy(Boolean hasInvoiceCopy) {
    this.hasInvoiceCopy = hasInvoiceCopy;
  }

  public Worksheet hasRegistrationProof(Boolean hasRegistrationProof) {
    this.hasRegistrationProof = hasRegistrationProof;
    return this;
  }

  /**
   * Get hasRegistrationProof
   * @return hasRegistrationProof
  */
  
  @Schema(name = "hasRegistrationProof", example = "false", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hasRegistrationProof")
  public Boolean getHasRegistrationProof() {
    return hasRegistrationProof;
  }

  public void setHasRegistrationProof(Boolean hasRegistrationProof) {
    this.hasRegistrationProof = hasRegistrationProof;
  }

  public Worksheet createdAt(OffsetDateTime createdAt) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Worksheet worksheet = (Worksheet) o;
    return Objects.equals(this.id, worksheet.id) &&
        Objects.equals(this.customId, worksheet.customId) &&
        Objects.equals(this.toolId, worksheet.toolId) &&
        Objects.equals(this.isWarranty, worksheet.isWarranty) &&
        Objects.equals(this.hasWarrantyCard, worksheet.hasWarrantyCard) &&
        Objects.equals(this.hasInvoiceCopy, worksheet.hasInvoiceCopy) &&
        Objects.equals(this.hasRegistrationProof, worksheet.hasRegistrationProof) &&
        Objects.equals(this.createdAt, worksheet.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customId, toolId, isWarranty, hasWarrantyCard, hasInvoiceCopy, hasRegistrationProof, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Worksheet {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customId: ").append(toIndentedString(customId)).append("\n");
    sb.append("    toolId: ").append(toIndentedString(toolId)).append("\n");
    sb.append("    isWarranty: ").append(toIndentedString(isWarranty)).append("\n");
    sb.append("    hasWarrantyCard: ").append(toIndentedString(hasWarrantyCard)).append("\n");
    sb.append("    hasInvoiceCopy: ").append(toIndentedString(hasInvoiceCopy)).append("\n");
    sb.append("    hasRegistrationProof: ").append(toIndentedString(hasRegistrationProof)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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


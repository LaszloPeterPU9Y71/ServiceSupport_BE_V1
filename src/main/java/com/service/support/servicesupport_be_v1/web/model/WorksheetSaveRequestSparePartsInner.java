package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * WorksheetSaveRequestSparePartsInner
 */

@JsonTypeName("WorksheetSaveRequest_spareParts_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-28T00:56:50.465067900+01:00[Europe/Budapest]")
public class WorksheetSaveRequestSparePartsInner {

  private Integer sparePartId;

  private Integer quantity;

  public WorksheetSaveRequestSparePartsInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public WorksheetSaveRequestSparePartsInner(Integer sparePartId, Integer quantity) {
    this.sparePartId = sparePartId;
    this.quantity = quantity;
  }

  public WorksheetSaveRequestSparePartsInner sparePartId(Integer sparePartId) {
    this.sparePartId = sparePartId;
    return this;
  }

  /**
   * Get sparePartId
   * @return sparePartId
  */
  @NotNull 
  @Schema(name = "sparePartId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sparePartId")
  public Integer getSparePartId() {
    return sparePartId;
  }

  public void setSparePartId(Integer sparePartId) {
    this.sparePartId = sparePartId;
  }

  public WorksheetSaveRequestSparePartsInner quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @NotNull 
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorksheetSaveRequestSparePartsInner worksheetSaveRequestSparePartsInner = (WorksheetSaveRequestSparePartsInner) o;
    return Objects.equals(this.sparePartId, worksheetSaveRequestSparePartsInner.sparePartId) &&
        Objects.equals(this.quantity, worksheetSaveRequestSparePartsInner.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sparePartId, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorksheetSaveRequestSparePartsInner {\n");
    sb.append("    sparePartId: ").append(toIndentedString(sparePartId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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


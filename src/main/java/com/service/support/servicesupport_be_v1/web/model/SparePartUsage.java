package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.service.support.servicesupport_be_v1.web.model.SparePart;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SparePartUsage
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-10T00:38:29.316816200+02:00[Europe/Budapest]")
public class SparePartUsage {

  private SparePart sparePart;

  private Integer quantity;

  public SparePartUsage sparePart(SparePart sparePart) {
    this.sparePart = sparePart;
    return this;
  }

  /**
   * Get sparePart
   * @return sparePart
  */
  @Valid 
  @Schema(name = "sparePart", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sparePart")
  public SparePart getSparePart() {
    return sparePart;
  }

  public void setSparePart(SparePart sparePart) {
    this.sparePart = sparePart;
  }

  public SparePartUsage quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    SparePartUsage sparePartUsage = (SparePartUsage) o;
    return Objects.equals(this.sparePart, sparePartUsage.sparePart) &&
        Objects.equals(this.quantity, sparePartUsage.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sparePart, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SparePartUsage {\n");
    sb.append("    sparePart: ").append(toIndentedString(sparePart)).append("\n");
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


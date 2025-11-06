package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SparePart
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-06T21:02:55.358968+01:00[Europe/Budapest]")
public class SparePart {

  private Integer id;

  private String itemName;

  private String itemNumber;

  private Integer nettoBuyingPrice;

  private Integer nettoSellingPrice;

  public SparePart id(Integer id) {
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

  public SparePart itemName(String itemName) {
    this.itemName = itemName;
    return this;
  }

  /**
   * Get itemName
   * @return itemName
  */
  
  @Schema(name = "itemName", example = "Csapágy 6203", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itemName")
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public SparePart itemNumber(String itemNumber) {
    this.itemNumber = itemNumber;
    return this;
  }

  /**
   * Get itemNumber
   * @return itemNumber
  */
  
  @Schema(name = "itemNumber", example = "BRG-6203", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itemNumber")
  public String getItemNumber() {
    return itemNumber;
  }

  public void setItemNumber(String itemNumber) {
    this.itemNumber = itemNumber;
  }

  public SparePart nettoBuyingPrice(Integer nettoBuyingPrice) {
    this.nettoBuyingPrice = nettoBuyingPrice;
    return this;
  }

  /**
   * Get nettoBuyingPrice
   * @return nettoBuyingPrice
  */
  
  @Schema(name = "nettoBuyingPrice", example = "1200", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nettoBuyingPrice")
  public Integer getNettoBuyingPrice() {
    return nettoBuyingPrice;
  }

  public void setNettoBuyingPrice(Integer nettoBuyingPrice) {
    this.nettoBuyingPrice = nettoBuyingPrice;
  }

  public SparePart nettoSellingPrice(Integer nettoSellingPrice) {
    this.nettoSellingPrice = nettoSellingPrice;
    return this;
  }

  /**
   * Get nettoSellingPrice
   * @return nettoSellingPrice
  */
  
  @Schema(name = "nettoSellingPrice", example = "1800", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nettoSellingPrice")
  public Integer getNettoSellingPrice() {
    return nettoSellingPrice;
  }

  public void setNettoSellingPrice(Integer nettoSellingPrice) {
    this.nettoSellingPrice = nettoSellingPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SparePart sparePart = (SparePart) o;
    return Objects.equals(this.id, sparePart.id) &&
        Objects.equals(this.itemName, sparePart.itemName) &&
        Objects.equals(this.itemNumber, sparePart.itemNumber) &&
        Objects.equals(this.nettoBuyingPrice, sparePart.nettoBuyingPrice) &&
        Objects.equals(this.nettoSellingPrice, sparePart.nettoSellingPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, itemName, itemNumber, nettoBuyingPrice, nettoSellingPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SparePart {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    itemName: ").append(toIndentedString(itemName)).append("\n");
    sb.append("    itemNumber: ").append(toIndentedString(itemNumber)).append("\n");
    sb.append("    nettoBuyingPrice: ").append(toIndentedString(nettoBuyingPrice)).append("\n");
    sb.append("    nettoSellingPrice: ").append(toIndentedString(nettoSellingPrice)).append("\n");
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


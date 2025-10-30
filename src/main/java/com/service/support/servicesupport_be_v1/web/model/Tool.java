package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.service.support.servicesupport_be_v1.web.model.OwnerCompanyEmployee;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Tool
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-30T22:18:23.181631200+01:00[Europe/Budapest]")
public class Tool {

  private Integer id;

  private String toolId;

  private String itemNumber;

  private String name;

  private String serialNumber;

  private String typeNumber;

  private OwnerCompanyEmployee owner;

  private String ownerName;

  private String ownerCompanyName;

  public Tool id(Integer id) {
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

  public Tool toolId(String toolId) {
    this.toolId = toolId;
    return this;
  }

  /**
   * Get toolId
   * @return toolId
  */
  
  @Schema(name = "tool_id", example = "2025-10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tool_id")
  public String getToolId() {
    return toolId;
  }

  public void setToolId(String toolId) {
    this.toolId = toolId;
  }

  public Tool itemNumber(String itemNumber) {
    this.itemNumber = itemNumber;
    return this;
  }

  /**
   * Get itemNumber
   * @return itemNumber
  */
  
  @Schema(name = "itemNumber", example = "ITM-001", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itemNumber")
  public String getItemNumber() {
    return itemNumber;
  }

  public void setItemNumber(String itemNumber) {
    this.itemNumber = itemNumber;
  }

  public Tool name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", example = "Fúrógép", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Tool serialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  /**
   * Get serialNumber
   * @return serialNumber
  */
  
  @Schema(name = "serialNumber", example = "SN-2025-0001", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("serialNumber")
  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Tool typeNumber(String typeNumber) {
    this.typeNumber = typeNumber;
    return this;
  }

  /**
   * Get typeNumber
   * @return typeNumber
  */
  
  @Schema(name = "typeNumber", example = "TYP-1234", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("typeNumber")
  public String getTypeNumber() {
    return typeNumber;
  }

  public void setTypeNumber(String typeNumber) {
    this.typeNumber = typeNumber;
  }

  public Tool owner(OwnerCompanyEmployee owner) {
    this.owner = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
  */
  @Valid 
  @Schema(name = "owner", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("owner")
  public OwnerCompanyEmployee getOwner() {
    return owner;
  }

  public void setOwner(OwnerCompanyEmployee owner) {
    this.owner = owner;
  }

  public Tool ownerName(String ownerName) {
    this.ownerName = ownerName;
    return this;
  }

  /**
   * Az ügyfél neve (kényelmi mező lista nézethez)
   * @return ownerName
  */
  
  @Schema(name = "ownerName", accessMode = Schema.AccessMode.READ_ONLY, example = "Kiss János", description = "Az ügyfél neve (kényelmi mező lista nézethez)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ownerName")
  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public Tool ownerCompanyName(String ownerCompanyName) {
    this.ownerCompanyName = ownerCompanyName;
    return this;
  }

  /**
   * Az ügyfél cégének neve lista nézethez
   * @return ownerCompanyName
  */
  
  @Schema(name = "ownerCompanyName", accessMode = Schema.AccessMode.READ_ONLY, example = "Szerszám Kuckó Kft.", description = "Az ügyfél cégének neve lista nézethez", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ownerCompanyName")
  public String getOwnerCompanyName() {
    return ownerCompanyName;
  }

  public void setOwnerCompanyName(String ownerCompanyName) {
    this.ownerCompanyName = ownerCompanyName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tool tool = (Tool) o;
    return Objects.equals(this.id, tool.id) &&
        Objects.equals(this.toolId, tool.toolId) &&
        Objects.equals(this.itemNumber, tool.itemNumber) &&
        Objects.equals(this.name, tool.name) &&
        Objects.equals(this.serialNumber, tool.serialNumber) &&
        Objects.equals(this.typeNumber, tool.typeNumber) &&
        Objects.equals(this.owner, tool.owner) &&
        Objects.equals(this.ownerName, tool.ownerName) &&
        Objects.equals(this.ownerCompanyName, tool.ownerCompanyName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, toolId, itemNumber, name, serialNumber, typeNumber, owner, ownerName, ownerCompanyName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tool {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    toolId: ").append(toIndentedString(toolId)).append("\n");
    sb.append("    itemNumber: ").append(toIndentedString(itemNumber)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    typeNumber: ").append(toIndentedString(typeNumber)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    ownerName: ").append(toIndentedString(ownerName)).append("\n");
    sb.append("    ownerCompanyName: ").append(toIndentedString(ownerCompanyName)).append("\n");
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


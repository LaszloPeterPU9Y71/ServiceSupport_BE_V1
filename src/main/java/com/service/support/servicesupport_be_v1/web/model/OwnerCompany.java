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
 * OwnerCompany
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-17T12:09:38.935371+01:00[Europe/Budapest]")
public class OwnerCompany {

  private Integer id;

  private String accountNumber;

  private String name;

  private Integer postalCode;

  private String street;

  private String taxNumber;

  private String town;

  public OwnerCompany id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public OwnerCompany accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  */
  
  @Schema(name = "accountNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountNumber")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public OwnerCompany name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OwnerCompany postalCode(Integer postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  */
  
  @Schema(name = "postalCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("postalCode")
  public Integer getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(Integer postalCode) {
    this.postalCode = postalCode;
  }

  public OwnerCompany street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Get street
   * @return street
  */
  
  @Schema(name = "street", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("street")
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public OwnerCompany taxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
    return this;
  }

  /**
   * Get taxNumber
   * @return taxNumber
  */
  
  @Schema(name = "taxNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taxNumber")
  public String getTaxNumber() {
    return taxNumber;
  }

  public void setTaxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
  }

  public OwnerCompany town(String town) {
    this.town = town;
    return this;
  }

  /**
   * Get town
   * @return town
  */
  
  @Schema(name = "town", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("town")
  public String getTown() {
    return town;
  }

  public void setTown(String town) {
    this.town = town;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OwnerCompany ownerCompany = (OwnerCompany) o;
    return Objects.equals(this.id, ownerCompany.id) &&
        Objects.equals(this.accountNumber, ownerCompany.accountNumber) &&
        Objects.equals(this.name, ownerCompany.name) &&
        Objects.equals(this.postalCode, ownerCompany.postalCode) &&
        Objects.equals(this.street, ownerCompany.street) &&
        Objects.equals(this.taxNumber, ownerCompany.taxNumber) &&
        Objects.equals(this.town, ownerCompany.town);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountNumber, name, postalCode, street, taxNumber, town);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OwnerCompany {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    taxNumber: ").append(toIndentedString(taxNumber)).append("\n");
    sb.append("    town: ").append(toIndentedString(town)).append("\n");
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


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
 * OwnerCompanyEmployee
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-17T20:54:47.397666300+02:00[Europe/Budapest]")
public class OwnerCompanyEmployee {

  private Integer id;

  private String email;

  private String name;

  private String telNum;

  private String title;

  private String ownerCompanyName;

  public OwnerCompanyEmployee id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "101", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public OwnerCompanyEmployee email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "john.doe@example.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public OwnerCompanyEmployee name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", example = "John Doe", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OwnerCompanyEmployee telNum(String telNum) {
    this.telNum = telNum;
    return this;
  }

  /**
   * Get telNum
   * @return telNum
  */
  
  @Schema(name = "telNum", example = "361234567", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telNum")
  public String getTelNum() {
    return telNum;
  }

  public void setTelNum(String telNum) {
    this.telNum = telNum;
  }

  public OwnerCompanyEmployee title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  
  @Schema(name = "title", example = "Software Engineer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public OwnerCompanyEmployee ownerCompanyName(String ownerCompanyName) {
    this.ownerCompanyName = ownerCompanyName;
    return this;
  }

  /**
   * Get ownerCompanyName
   * @return ownerCompanyName
  */
  
  @Schema(name = "ownerCompanyName", example = "Jóska Kft", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    OwnerCompanyEmployee ownerCompanyEmployee = (OwnerCompanyEmployee) o;
    return Objects.equals(this.id, ownerCompanyEmployee.id) &&
        Objects.equals(this.email, ownerCompanyEmployee.email) &&
        Objects.equals(this.name, ownerCompanyEmployee.name) &&
        Objects.equals(this.telNum, ownerCompanyEmployee.telNum) &&
        Objects.equals(this.title, ownerCompanyEmployee.title) &&
        Objects.equals(this.ownerCompanyName, ownerCompanyEmployee.ownerCompanyName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, name, telNum, title, ownerCompanyName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OwnerCompanyEmployee {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    telNum: ").append(toIndentedString(telNum)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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


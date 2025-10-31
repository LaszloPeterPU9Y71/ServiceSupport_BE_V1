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
 * ChangePasswordWithTokenRequest
 */

@JsonTypeName("changePasswordWithToken_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-31T20:50:27.221031900+01:00[Europe/Budapest]")
public class ChangePasswordWithTokenRequest {

  private String email;

  private String token;

  private String newPassword;

  public ChangePasswordWithTokenRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ChangePasswordWithTokenRequest(String email, String token, String newPassword) {
    this.email = email;
    this.token = token;
    this.newPassword = newPassword;
  }

  public ChangePasswordWithTokenRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ChangePasswordWithTokenRequest token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
  */
  @NotNull 
  @Schema(name = "token", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ChangePasswordWithTokenRequest newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  /**
   * Get newPassword
   * @return newPassword
  */
  @NotNull 
  @Schema(name = "newPassword", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("newPassword")
  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangePasswordWithTokenRequest changePasswordWithTokenRequest = (ChangePasswordWithTokenRequest) o;
    return Objects.equals(this.email, changePasswordWithTokenRequest.email) &&
        Objects.equals(this.token, changePasswordWithTokenRequest.token) &&
        Objects.equals(this.newPassword, changePasswordWithTokenRequest.newPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, token, newPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangePasswordWithTokenRequest {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    newPassword: ").append("*").append("\n");
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


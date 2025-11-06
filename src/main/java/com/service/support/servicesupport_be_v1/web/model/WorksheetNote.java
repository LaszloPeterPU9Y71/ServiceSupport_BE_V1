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
 * WorksheetNote
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-06T21:02:55.358968+01:00[Europe/Budapest]")
public class WorksheetNote {

  private Integer noteId;

  private Integer userId;

  private String noteText;

  private String userName;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime postedDate;

  public WorksheetNote noteId(Integer noteId) {
    this.noteId = noteId;
    return this;
  }

  /**
   * Get noteId
   * @return noteId
  */
  
  @Schema(name = "noteId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("noteId")
  public Integer getNoteId() {
    return noteId;
  }

  public void setNoteId(Integer noteId) {
    this.noteId = noteId;
  }

  public WorksheetNote userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public WorksheetNote noteText(String noteText) {
    this.noteText = noteText;
    return this;
  }

  /**
   * Get noteText
   * @return noteText
  */
  
  @Schema(name = "noteText", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("noteText")
  public String getNoteText() {
    return noteText;
  }

  public void setNoteText(String noteText) {
    this.noteText = noteText;
  }

  public WorksheetNote userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  */
  
  @Schema(name = "userName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userName")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public WorksheetNote postedDate(OffsetDateTime postedDate) {
    this.postedDate = postedDate;
    return this;
  }

  /**
   * Get postedDate
   * @return postedDate
  */
  @Valid 
  @Schema(name = "postedDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("postedDate")
  public OffsetDateTime getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(OffsetDateTime postedDate) {
    this.postedDate = postedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorksheetNote worksheetNote = (WorksheetNote) o;
    return Objects.equals(this.noteId, worksheetNote.noteId) &&
        Objects.equals(this.userId, worksheetNote.userId) &&
        Objects.equals(this.noteText, worksheetNote.noteText) &&
        Objects.equals(this.userName, worksheetNote.userName) &&
        Objects.equals(this.postedDate, worksheetNote.postedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(noteId, userId, noteText, userName, postedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorksheetNote {\n");
    sb.append("    noteId: ").append(toIndentedString(noteId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    noteText: ").append(toIndentedString(noteText)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    postedDate: ").append(toIndentedString(postedDate)).append("\n");
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


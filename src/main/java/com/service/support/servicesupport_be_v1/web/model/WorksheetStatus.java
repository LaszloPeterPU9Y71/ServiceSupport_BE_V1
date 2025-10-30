package com.service.support.servicesupport_be_v1.web.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A munkalap státusza
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-30T22:18:23.181631200+01:00[Europe/Budapest]")
public enum WorksheetStatus {
  
  BEERKEZETT("BEERKEZETT"),
  
  FOLYAMATBAN("FOLYAMATBAN"),
  
  FELKULDVE("FELKULDVE"),
  
  VISSZAERKEZETT("VISSZAERKEZETT"),
  
  KIAJANLOTT("KIAJANLOTT"),
  
  ELFOGADVA("ELFOGADVA"),
  
  KIERTESTVE("KIERTESTVE"),
  
  LEZART("LEZART");

  private String value;

  WorksheetStatus(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static WorksheetStatus fromValue(String value) {
    for (WorksheetStatus b : WorksheetStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


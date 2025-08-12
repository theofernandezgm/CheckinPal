// src/main/java/com/checkinpal/app/web/dto/SignupRequest.java
package com.checkinpal.app.web.dto;

// A simple record to represent the JSON data for a signup request
public record SignupRequest(String email, String password, String legalName, String nif) {
}
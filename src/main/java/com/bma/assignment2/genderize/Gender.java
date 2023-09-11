package com.bma.assignment2.genderize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Gender(String name, String gender) {
}

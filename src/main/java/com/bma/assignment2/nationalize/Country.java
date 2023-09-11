package com.bma.assignment2.nationalize;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Country(@JsonProperty("country_id") String countryId, Double probability) {
}

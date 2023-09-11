package com.bma.assignment2.nationalize;

import com.bma.assignment2.users.VerificationStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record NationalityResponse(@JsonProperty("country") List<Country> countries) {
    public boolean contains(String nationality) {
        return countries.stream().anyMatch(country -> country.countryId().equals(nationality));
    }
}

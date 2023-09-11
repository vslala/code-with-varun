package com.bma.assignment2.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(String gender, Name name, @JsonProperty("nat") String nationality, Login login, DateOfBirth dob) {
}

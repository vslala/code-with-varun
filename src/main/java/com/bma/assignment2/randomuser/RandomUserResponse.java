package com.bma.assignment2.randomuser;

import com.bma.assignment2.users.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RandomUserResponse(List<User> results) {
}

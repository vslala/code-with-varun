package com.bma.assignment2.users;

public record Name(String title, String first, String last) {
    public String fullName() {
        return this.first + " " + this.last;
    }
}

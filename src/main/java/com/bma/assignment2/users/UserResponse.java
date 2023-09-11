package com.bma.assignment2.users;

import com.bma.assignment2.genderize.Gender;
import com.bma.assignment2.nationalize.NationalityResponse;
import lombok.Data;

public record UserResponse(String userId, String name, int age, String gender, String dob, String nationality, VerificationStatus verificationStatus, String dateCreated, String dateModified) {

    @Data
    public static class UserResponseBuilder {
        private String userId;
        private String name;
        private int age;
        private String gender;
        private String dob;
        private String nationality;
        private VerificationStatus verificationStatus = VerificationStatus.NOT_VERIFIED;
        private String dateCreated;
        private String dateModified;

        public UserResponseBuilder user(User user, NationalityResponse nationalities, Gender gender) {
            userId(user.login().uuid());
            name(user.name().fullName());
            age(user.dob().age());
            gender(user.gender());
            dob(user.dob().date());
            nationality(user.nationality());
            gender(user.gender());
            verificationStatus(nationalities.contains(user.nationality()) && user.gender().equals(gender.gender()) ? VerificationStatus.VERIFIED : VerificationStatus.NOT_VERIFIED);
            return this;
        }

        public UserResponseBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserResponseBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserResponseBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserResponseBuilder dob(String dob) {
            this.dob = dob;
            return this;
        }

        public UserResponseBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public UserResponseBuilder verificationStatus(VerificationStatus verificationStatus) {
            this.verificationStatus = verificationStatus;
            return this;
        }

        public UserResponseBuilder dateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public UserResponseBuilder dateModified(String dateModified) {
            this.dateModified = dateModified;
            return this;
        }

        public UserResponse build() {
            return new UserResponse(userId, name, age, gender, dob, nationality, verificationStatus, dateCreated, dateModified);
        }
    }
}

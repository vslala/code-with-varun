package com.bma.assignment2.users;

import com.bma.assignment2.genderize.Gender;
import com.bma.assignment2.genderize.GenderService;
import com.bma.assignment2.nationalize.Country;
import com.bma.assignment2.nationalize.NationalityResponse;
import com.bma.assignment2.nationalize.NationalityService;
import com.bma.assignment2.randomuser.RandomUserResponse;
import com.bma.assignment2.randomuser.RandomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final RandomUserService randomUserService;
    private final NationalityService nationalityService;
    private final GenderService genderService;


    @Autowired
    public UserService(RandomUserService randomUserService, NationalityService nationalityService, GenderService genderService) {
        this.randomUserService = randomUserService;
        this.nationalityService = nationalityService;
        this.genderService = genderService;
    }

    public List<UserResponse> getUser(UserRequest userRequest) {
        RandomUserResponse randomUserResponse = this.randomUserService.getRandomUsers(userRequest);
        List<User> randomUsers = randomUserResponse.results();
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            return randomUsers.stream().map(user -> {
                CompletableFuture<NationalityResponse> nationalityResponse = CompletableFuture.supplyAsync(() -> this.nationalityService.getUserCountry(user.name()), executorService);
                CompletableFuture<Gender> genderResponse = CompletableFuture.supplyAsync(() -> this.genderService.getUserGender(user.name()), executorService);
                CompletableFuture.allOf(nationalityResponse, genderResponse).join();

                NationalityResponse nationalities = nationalityResponse.join();
                Gender gender = genderResponse.join();

                return new UserResponse.UserResponseBuilder()
                        .user(user, nationalities, gender)
                        .build();
            }).collect(Collectors.toList());
        }
    }
}

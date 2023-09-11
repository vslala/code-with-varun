package com.bma.assignment2.randomuser;

import com.bma.assignment2.users.UserRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RandomUserService {

    private final WebClient webClient;

    public RandomUserService(WebClient webClient) {
        this.webClient = webClient;
    }


    public RandomUserResponse getRandomUsers(UserRequest userRequest) {
        return this.webClient.get().uri("https://randomuser.me/api/?results=%d".formatted(userRequest.size()))
                .retrieve()
                .bodyToMono(RandomUserResponse.class)
                .block();
    }
}

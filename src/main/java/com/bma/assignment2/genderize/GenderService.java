package com.bma.assignment2.genderize;

import com.bma.assignment2.users.Name;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GenderService {

    private final WebClient webClient;

    public GenderService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Gender getUserGender(Name name) {
        return this.webClient.get().uri("https://api.genderize.io/?name=%s".formatted(name.first()))
                .retrieve()
                .bodyToMono(Gender.class)
                .block();
    }
}

package com.bma.assignment2.nationalize;

import com.bma.assignment2.users.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NationalityService {

    private final WebClient webClient;

    @Autowired
    public NationalityService(WebClient webClient) {
        this.webClient = webClient;
    }


    public NationalityResponse getUserCountry(Name name) {

        return webClient.get().uri("https://api.nationalize.io/?name=%s".formatted(name.first()))
                .retrieve()
                .bodyToMono(NationalityResponse.class)
                .block();
    }
}

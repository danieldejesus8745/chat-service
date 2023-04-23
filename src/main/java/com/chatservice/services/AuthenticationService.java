package com.chatservice.services;

import com.chatservice.utils.MessagesEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.chatservice.utils.Constants.AUTHENTICATION_SERVICE_ENDPOINT;
import static com.chatservice.utils.MessagesEnum.MESSAGE_1;

@Slf4j
@Service
public class AuthenticationService {

    public boolean validateToken(String token) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(AUTHENTICATION_SERVICE_ENDPOINT))
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return handleResposnse(response);
        } catch (InterruptedException | IOException exception) {
            log.error(MESSAGE_1.getMessage() + "." + exception.getMessage());
            throw new IllegalStateException();
        }
    }

    private boolean handleResposnse(HttpResponse<String> response) {
        return Boolean.getBoolean(response.body());
    }

}

package com.chatservice.controllers;

import com.chatservice.dto.MessageDTO;
import com.chatservice.services.AuthenticationService;
import com.chatservice.services.MessageService;
import com.chatservice.utils.MessagesEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.chatservice.utils.MessagesEnum.*;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/messages")
public class MessageController {

    private final MessageService messageService;
    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<String> addMessage(@RequestHeader(AUTHORIZATION) String token,
                                             @RequestBody MessageDTO messageDTO) {
        boolean isValidToken;

        try {
            isValidToken = authenticationService.validateToken(token);
        } catch (IllegalStateException exception) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(MESSAGE_4.getMessage());
        }

        if (isValidToken) {
            messageService.addMessage(messageDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(MESSAGE_2.getMessage());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(MESSAGE_3.getMessage());
    }

}

package com.chatservice.controllers;

import com.chatservice.dto.MessageDTO;
import com.chatservice.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.chatservice.utils.MessagesEnum.MESSAGE_1;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/messages")
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<String> addMessage(@RequestBody MessageDTO messageDTO) {
        messageService.addMessage(messageDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(MESSAGE_1.getMessage());
    }

}

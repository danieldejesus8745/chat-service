package com.chatservice.controllers;

import com.chatservice.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/messages")
public class MessageController {

    private final MessageService messageService;

}

package com.chatservice.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesEnum {

    MESSAGE_1("Message sent successfully");

    private final String message;

}

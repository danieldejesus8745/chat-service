package com.chatservice.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesEnum {

    MESSAGE_1("Error when trying to validate token"),
    MESSAGE_2("Message sent with success"),
    MESSAGE_3("Invalid Token"),
    MESSAGE_4("Unable to validate token");

    private final String message;

}

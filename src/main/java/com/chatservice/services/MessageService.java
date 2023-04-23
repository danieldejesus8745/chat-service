package com.chatservice.services;

import com.chatservice.dto.MessageDTO;
import com.chatservice.entities.Message;
import com.chatservice.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public void addMessage(MessageDTO messageDTO) {
        messageDTO.setCreatedAt(LocalDateTime.now());
        Message message = new Message();
        BeanUtils.copyProperties(messageDTO, message);
        messageRepository.save(message);
    }

}

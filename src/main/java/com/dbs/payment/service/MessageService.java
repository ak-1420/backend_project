package com.dbs.payment.service;

import com.dbs.payment.entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    Message addMessage(Message message);

    List<Message> fetchAllMessages();

    Optional<Message> fetchMessage(String messageCode);

    Optional<Message> updateMessage(String messageCode, Message message);

    String deleteMessage(String messageCode);
}

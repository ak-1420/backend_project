package com.dbs.payment.service;

import com.dbs.payment.entity.Message;
import com.dbs.payment.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImplementation implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> fetchAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> fetchMessage(String messageCode) {
        return messageRepository.findById(messageCode);
    }

    @Override
    public Optional<Message> updateMessage(String messageCode, Message message) {
        Optional<Message> oMsg = messageRepository.findById(messageCode);
        if(oMsg.isPresent()){
            Message msg = oMsg.get();
            msg.setInstruction(message.getInstruction());
            messageRepository.save(msg);
        }
        return messageRepository.findById(messageCode);
    }

    @Override
    public String deleteMessage(String messageCode) {
        Optional<Message> oMsg = messageRepository.findById(messageCode);
        if(oMsg.isPresent()){
            messageRepository.deleteById(messageCode);
            return "message record deleted successfully!";
        }
        return "unable to delete the record";
    }
}

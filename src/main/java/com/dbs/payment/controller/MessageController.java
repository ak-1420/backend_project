package com.dbs.payment.controller;

import com.dbs.payment.entity.Message;
import com.dbs.payment.repository.MessageRepository;
import com.dbs.payment.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/add")
    public Message addMessage(@PathVariable Message message){
        return messageService.addMessage(message);
    }

    @GetMapping("/all")
    public List<Message> fetchAllMessages(){
        return messageService.fetchAllMessages();
    }

    @GetMapping("/{messageCode}")
    public Optional<Message> fetchMessage(@PathVariable String messageCode){
        return messageService.fetchMessage(messageCode);
    }

    @PatchMapping("/{messageCode}")
    public Optional<Message> updateMessage(@PathVariable String messageCode ,@RequestBody Message message){
        return messageService.updateMessage(messageCode , message);
    }

    @DeleteMapping("/{messageCode}")
    public String deleteMessage(@PathVariable String messageCode){
       return messageService.deleteMessage(messageCode);
    }

}

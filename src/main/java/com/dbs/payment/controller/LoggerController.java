package com.dbs.payment.controller;

import com.dbs.payment.entity.Logger;
import com.dbs.payment.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/logger")
public class LoggerController {

    @Autowired
    private LoggerService loggerService;

    @PostMapping("/add")
    public Logger addLog(@RequestBody Logger log){
        return loggerService.addLog(log);
    }

    @GetMapping("/{id}")
    public Optional<Logger> getLogById(@PathVariable Long id){
        return loggerService.getLogById(id);
    }

    @GetMapping("/all")
    public List<Logger> getLogs(){
        return loggerService.getLogs();
    }

    @PatchMapping("/{id}")
    public Optional<Logger> updateLog(@PathVariable Long id ,@RequestBody Logger log){
        return loggerService.updateLog(id , log);
    }

    @DeleteMapping("/{id}")
    public String deleteLog(@PathVariable Long id){
        return loggerService.deleteLog(id);
    }
}

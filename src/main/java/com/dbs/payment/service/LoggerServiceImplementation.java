package com.dbs.payment.service;

import com.dbs.payment.entity.Logger;
import com.dbs.payment.repository.LoggerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoggerServiceImplementation implements LoggerService{

    private LoggerRepository loggerRepository;

    @Override
    public Logger addLog(Logger log) {
        return loggerRepository.save(log);
    }

    @Override
    public Optional<Logger> getLogById(Long id) {
        return loggerRepository.findById(id);
    }

    @Override
    public List<Logger> getLogs() {
        return loggerRepository.findAll();
    }

    @Override
    public Optional<Logger> updateLog(Long id, Logger log) {
        Optional<Logger> lg = loggerRepository.findById(id);
          if(lg.isPresent()){
              Logger  logger = lg.get();

              logger.setAction(log.getAction());
              logger.setIpAddress(log.getIpAddress());
              logger.setCustomerId(log.getCustomerId());
              logger.setEmployeeId(log.getEmployeeId());
              logger.setUserId(log.getUserId());
              logger.setScreenName(log.getScreenName());
              loggerRepository.save(logger);
          }
        
        return loggerRepository.findById(id);
    }

    @Override
    public String deleteLog(Long id) {
        Optional<Logger> lg = loggerRepository.findById(id);
        if(lg.isPresent()){
            loggerRepository.deleteById(id);
            return "record deleted successfully!";
        }
        return "unable to delete the logger record";
    }
}

package com.dbs.payment.service;

import com.dbs.payment.entity.Logger;

import java.util.List;
import java.util.Optional;

public interface LoggerService {
    Logger addLog(Logger log);
    Optional<Logger> getLogById(Long id);
    List<Logger> getLogs();
    String deleteLog(Long id);
}

package com.github.atilla8huno.logger.error;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

@Service
@AllArgsConstructor
public class ErrorLoggerImpl implements ErrorLogger {

    private final Logger logger;

    @Override
    public void error(@NonNull String message,
                      Throwable thrown) {
        logger.log(SEVERE, message, thrown);
    }
}

package com.github.atilla8huno.logger.info;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class InfoLoggerImpl implements InfoLogger {

    private final Logger logger;

    @Override
    public void info(@NonNull String message,
                     Object... args) {
        logger.info(format(message, args));
    }
}

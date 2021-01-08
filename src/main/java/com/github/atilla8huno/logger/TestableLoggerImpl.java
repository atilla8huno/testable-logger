package com.github.atilla8huno.logger;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.slf4j.Logger;

@AllArgsConstructor
public class TestableLoggerImpl implements TestableLogger {

    private final Logger logger;

    @Override
    public void warn(@NonNull String message,
                     Object... args) {
        logger.warn(message, args);
    }

    @Override
    public void info(@NonNull String message,
                     Object... args) {
        logger.info(message, args);
    }

    @Override
    public void error(@NonNull String message,
                      Throwable thrown) {
        logger.error(message, thrown);
    }
}

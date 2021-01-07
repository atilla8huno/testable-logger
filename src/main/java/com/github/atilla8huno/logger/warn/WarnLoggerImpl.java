package com.github.atilla8huno.logger.warn;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class WarnLoggerImpl implements WarnLogger {

    private final Logger logger;

    @Override
    public void warning(@NonNull String message,
                        Object... args) {
        logger.warning(format(message, args));
    }
}

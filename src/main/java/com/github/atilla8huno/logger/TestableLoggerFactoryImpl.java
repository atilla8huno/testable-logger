package com.github.atilla8huno.logger;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestableLoggerFactoryImpl implements TestableLoggerFactory {

    @Override
    public <T> TestableLogger getLogger(Class<T> clazz) {
        return new TestableLoggerImpl(org.slf4j.LoggerFactory.getLogger(clazz));
    }
}

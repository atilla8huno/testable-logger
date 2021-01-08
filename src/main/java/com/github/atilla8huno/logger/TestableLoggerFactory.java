package com.github.atilla8huno.logger;

public interface TestableLoggerFactory {
    <T> TestableLogger getLogger(Class<T> clazz);
}

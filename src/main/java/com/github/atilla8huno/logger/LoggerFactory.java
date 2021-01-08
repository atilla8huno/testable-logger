package com.github.atilla8huno.logger;

public interface LoggerFactory {
    <T> TestableLogger getLogger(Class<T> clazz);
}

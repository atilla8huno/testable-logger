package com.github.atilla8huno.logger.error;

public interface ErrorLogger {

    void error(String message,
               Throwable thrown);
}

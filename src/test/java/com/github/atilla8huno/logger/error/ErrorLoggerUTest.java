package com.github.atilla8huno.logger.error;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("Test suite of the class: ErrorLogger")
class ErrorLoggerUTest {

    private ErrorLogger underTest;
    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = mock(Logger.class);
        underTest = new ErrorLoggerImpl(logger);
    }

    @Test
    @DisplayName("Should log the content of a message object")
    void givenContent_whenInfo_thenShouldLogMessageAsSevere() {
        //given
        String message = "This is a useful message";

        //when
        underTest.error(message, null);

        //then
        verify(logger).log(eq(SEVERE), eq(message), isNull(Throwable.class));
    }

    @Test
    @DisplayName("Should log the content of a message object and an exception")
    void givenContentAndException_whenInfo_thenShouldLogMessageAsSevereWithException() {
        //given
        String message = "This is a useful message";
        Throwable thrown = new Exception("This is bad");

        //when
        underTest.error(message, thrown);

        //then
        verify(logger).log(eq(SEVERE), eq(message), eq(thrown));
    }

    @Test
    @DisplayName("Should throw exception if message is invalid")
    void givenNullContent_whenInfo_thenShouldThrowException() {
        //given
        String message = null;
        Throwable thrown = null;

        //when
        Executable error = () -> underTest.error(message, thrown);

        //then
        assertThrows(IllegalArgumentException.class, error);
    }
}

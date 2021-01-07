package com.github.atilla8huno.logger.info;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("Test suite of the class: InfoLogger")
class InfoLoggerUTest {

    private InfoLogger underTest;
    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = mock(Logger.class);
        underTest = new InfoLoggerImpl(logger);
    }

    @Test
    @DisplayName("Should log the content of a message object")
    void givenContent_whenInfo_thenShouldLogMessageAsInfo() {
        //given
        String message = "This is a useful message";

        //when
        underTest.info(message);

        //then
        verify(logger).info(eq(message));
    }

    @Test
    @DisplayName("Should log the content of a message object with params")
    void givenContentAndParams_whenInfo_thenShouldLogMessageAsInfoWithParams() {
        //given
        String message = "This is a useful message";
        Integer param1 = 1;
        List<String> param2 = new ArrayList<>();

        //when
        underTest.info(message, param1, param2);

        //then
        verify(logger).info(eq(format(message, param1, param2)));
    }

    @Test
    @DisplayName("Should throw exception if message is invalid")
    void givenNullContent_whenInfo_thenShouldThrowException() {
        //given
        String message = null;

        //when
        Executable info = () -> underTest.info(message);

        //then
        assertThrows(IllegalArgumentException.class, info);
    }
}

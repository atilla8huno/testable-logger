package com.github.atilla8huno.logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

@DisplayName("Test suite of the class: LoggerFactory")
public class LoggerFactoryUTest {

    private LoggerFactory underTest;
    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = mock(Logger.class);

        MockedStatic<org.slf4j.LoggerFactory> loggerFactory =
                mockStatic(org.slf4j.LoggerFactory.class);
        loggerFactory
                .when(() -> org.slf4j.LoggerFactory.getLogger(any(Class.class)))
                .thenReturn(logger);

        underTest = new LoggerFactoryImpl();
    }

    @Test
    void givenClass_whenGetLogger_thenShouldGetGenericInstanceOfLogger() {
        //given
        Class<String> clazz = String.class;

        //when
        TestableLogger logger = underTest.getLogger(clazz);

        //then
        assertNotNull(logger);
    }
}

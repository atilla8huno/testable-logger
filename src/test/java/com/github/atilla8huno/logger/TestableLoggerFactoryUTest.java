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
import static org.mockito.Mockito.times;

@DisplayName("Test suite of the class: TestableLoggerFactory")
public class TestableLoggerFactoryUTest {

    private TestableLoggerFactory underTest;
    MockedStatic<org.slf4j.LoggerFactory> loggerFactory;

    @BeforeEach
    void setUp() {
        Logger logger = mock(Logger.class);

        loggerFactory = mockStatic(org.slf4j.LoggerFactory.class);
        loggerFactory
                .when(() -> org.slf4j.LoggerFactory.getLogger(any(Class.class)))
                .thenReturn(logger);

        underTest = new TestableLoggerFactoryImpl();
    }

    @Test
    void givenClass_whenGetLogger_thenShouldGetGenericInstanceOfLogger() {
        //given
        Class<String> clazz = String.class;

        //when
        TestableLogger logger = underTest.getLogger(clazz);

        //then
        assertNotNull(logger);
        loggerFactory.verify(times(1),
                () -> org.slf4j.LoggerFactory.getLogger(clazz));
    }
}

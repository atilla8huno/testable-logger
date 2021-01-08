package com.github.atilla8huno.logger;

import com.github.atilla8huno.logger.error.ErrorLogger;
import com.github.atilla8huno.logger.info.InfoLogger;
import com.github.atilla8huno.logger.warn.WarnLogger;

public interface TestableLogger extends InfoLogger, WarnLogger, ErrorLogger {
}

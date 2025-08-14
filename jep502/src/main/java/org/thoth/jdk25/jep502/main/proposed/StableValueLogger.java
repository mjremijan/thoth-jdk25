package org.thoth.jdk25.jep502.main.proposed;

import java.util.logging.Logger;

public class StableValueLogger {
  private final StableValue<Logger> logger = StableValue.of();

  Logger getLog() {
    return logger.orElseSet(() -> Logger.getLogger(StableValueLogger.class.getName()));
  }

  public void service() {
    getLog().info("service() method start");
  }
}
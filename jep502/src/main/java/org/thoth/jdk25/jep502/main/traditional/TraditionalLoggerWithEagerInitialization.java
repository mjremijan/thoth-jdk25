package org.thoth.jdk25.jep502.main.traditional;

import java.util.logging.Logger;

public class TraditionalLoggerWithEagerInitialization {
  private static final Logger log
    = Logger.getLogger(TraditionalLoggerWithEagerInitialization.class.getName());
  
  public void service() {
      log.info("service() method start");
  }
}
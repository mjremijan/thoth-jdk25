package org.thoth.jdk25.jep502.main.traditional;

import java.util.logging.Logger;

public class TraditionalLoggerWithLazyInitialization {
  private static Logger log;
  
  private static Logger getLog() {
    if (log == null) {
      log = Logger.getLogger(TraditionalLoggerWithLazyInitialization.class.getName()); 
    }
    return log;
  }
  
  public void service() {
      getLog().info("service() method start");
  }
}
package org.thoth.jdk25.jep502.main.proposed;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class StableSupplierLogger {
  private final Supplier<Logger> logger 
    = StableValue.supplier(() -> Logger.getLogger(StableSupplierLogger.class.getName()));

  public void service() {
    logger.get().info("service() method start");
  }
}
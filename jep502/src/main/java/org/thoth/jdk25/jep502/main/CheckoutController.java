package org.thoth.jdk25.jep502.main;

import java.util.function.Supplier;
import java.util.logging.Logger;


/**
 *
 * @author H1MJR01
 */
public class CheckoutController {

    private final Supplier<Logger> logger 
        = StableValue.supplier(() -> Logger.getLogger(CheckoutController.class.getName()));
    
    void checkout() {
        logger.get().info("Checkout started");
        logger.get().info("Checkout complete");
    }
}

package org.thoth.jdk25.jep502.main;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author H1MJR01
 */
public class OrderController {

    private static int INSTANCE_COUNT = 0;
    
    private final StableValue<Logger> logger = StableValue.of();
    
    private final int instanceId;
    
    public OrderController() {
        instanceId = ++INSTANCE_COUNT;
    }
    
    Logger getLogger() {
        return logger.orElseSet(() -> Logger.getLogger(OrderController.class.getName()));
    }
    
    void submitOrder() {
        getLogger().log(Level.INFO, "Order started on controller {0}", instanceId);
        getLogger().log(Level.INFO, "Order submitted on controller {0}", instanceId);
    }
}

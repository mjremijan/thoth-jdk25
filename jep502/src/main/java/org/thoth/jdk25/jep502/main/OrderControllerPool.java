package org.thoth.jdk25.jep502.main;

import java.util.List;


/**
 *
 * @author H1MJR01
 */
public class OrderControllerPool {

    private static final int POOL_SIZE = 10;
    
    private static final List<OrderController> ORDERS
        = StableValue.list(10, _ -> new OrderController());
    
    public static OrderController getController() {
        int idx = (int)(Thread.currentThread().threadId() % 10);
        return ORDERS.get(idx);
    }
}

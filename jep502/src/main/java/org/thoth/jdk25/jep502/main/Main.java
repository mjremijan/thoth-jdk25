
package org.thoth.jdk25.jep502.main;

/**
 */
public class Main {

    public static void main(String[] args) throws Exception {
        
        System.out.printf("Welcome to JEP 502%n%n");
        
        System.out.printf("Create OrderController%n");
        OrderController orderController = new OrderController();        
        System.out.printf("submitOrder()%n");
        orderController.submitOrder();
        
        System.out.printf("Create CheckoutController%n");
        CheckoutController checkoutController = new CheckoutController();        
        System.out.printf("checkout()%n");
        checkoutController.checkout();
        
        System.out.printf("Get OrderController from pool%n");
        OrderController pooledOrderController = OrderControllerPool.getController();
        System.out.printf("submitOrder()%n");
        pooledOrderController.submitOrder();
        
        System.out.printf("%nGood bye!%n");
    }
}

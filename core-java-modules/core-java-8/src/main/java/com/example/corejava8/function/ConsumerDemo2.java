package com.example.corejava8.function;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo2 {

    public static void sendConfirmationEmail(Order order) {
        // Code to send confirmation email goes here
        System.out.println("Sending confirmation email to " + order.getEmail());
    }

    public static void processOrders(List<Order> orders, Consumer<Order> emailConsumer) {
        orders.forEach(order -> {
            // Process the order
            System.out.println("Processing order " + order.getId());

            // Send confirmation email to the customer
            emailConsumer.accept(order);
        });
    }

    public static void main(String[] args) {
        // Create a list of orders
//        List<Order> orders = getOrdersFromDatabase();
        List<Order> orders = new ArrayList<>();
        orders.add(Order.builder().orderNo("P123").id(1L).orderPrice(BigDecimal.valueOf(9.9)).email("notice@gmail.com").build());
        orders.add(Order.builder().orderNo("P124").id(2L).orderPrice(BigDecimal.valueOf(19.9)).email("notice@gmail.com").build());


        // Define a Consumer that sends a confirmation email for each order
        Consumer<Order> emailConsumer = ConsumerDemo2::sendConfirmationEmail;

        // Process the orders and send confirmation emails
        processOrders(orders, emailConsumer);
    }
}

package com.online.ecommerce.service;

public class OrderStatusBackgroundTask extends Thread {

    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                // In real life, update order statuses or send notifications
                System.out.println("Background task checking orders...");
                Thread.sleep(60000); // sleep 1 minute
            } catch (InterruptedException e) {
                running = false;
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

package com.online.ecommerce.service;

import com.online.ecommerce.model.Order;

public interface OrderProcessable {
    void processOrder(Order order);
}

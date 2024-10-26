package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();

    Order creatOrder(Order order);

    Order getOrderById(Long id);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);
}

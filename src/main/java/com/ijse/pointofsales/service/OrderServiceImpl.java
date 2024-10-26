package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.Order;
import com.ijse.pointofsales.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order creatOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order exisOrder = orderRepository.findById(id).orElse(order);
        if (exisOrder == null) {
            return null;
        } else {
            exisOrder.setOrderItems(order.getOrderItems());
            exisOrder.setTotalPrice(order.getTotalPrice());

            return orderRepository.save(exisOrder);
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}

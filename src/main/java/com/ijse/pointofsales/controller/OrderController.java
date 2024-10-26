package com.ijse.pointofsales.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pointofsales.dto.OrderRequestDto;
import com.ijse.pointofsales.entity.Items;
import com.ijse.pointofsales.entity.Order;
import com.ijse.pointofsales.service.ItemService;
import com.ijse.pointofsales.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> order = orderService.getAllOrders();
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> createOrders(@RequestBody OrderRequestDto dto) {
        List<Long> itemIds = dto.getItemIds();

        Order order = new Order();
        order.setTotalPrice(0.0);
        List<Items> orderedItems = new ArrayList<>();

        itemIds.forEach(itemId -> {
            Items item = itemService.getItemById(itemId);

            if (item != null) {
                orderedItems.add(item);
                order.setTotalPrice(order.getTotalPrice() + item.getPrice());
            }
        });

        order.setOrderItems(orderedItems);
        orderService.creatOrder(order);
        return ResponseEntity.ok(order);
    }
}

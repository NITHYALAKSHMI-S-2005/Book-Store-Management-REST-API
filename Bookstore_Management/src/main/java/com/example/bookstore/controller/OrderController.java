package com.example.bookstore.controller;

import com.example.bookstore.entity.Order;
import com.example.bookstore.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) { this.service = service; }

    @PostMapping("/place")
    public Order placeOrder(@RequestParam Long customerId,
                            @RequestParam Long bookId,
                            @RequestParam int quantity) {
        return service.placeOrder(customerId, bookId, quantity);
    }

    @GetMapping
    public List<Order> getOrders() { return service.getOrders(); }
}

package com.example.bookstore.service;

import com.example.bookstore.entity.*;
import com.example.bookstore.exception.ResourceNotFoundException;
import com.example.bookstore.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final BookRepository bookRepo;

    public OrderService(OrderRepository orderRepo, CustomerRepository customerRepo, BookRepository bookRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.bookRepo = bookRepo;
    }

    public Order placeOrder(Long customerId, Long bookId, int quantity) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        if (book.getStock() < quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }

        book.setStock(book.getStock() - quantity);
        bookRepo.save(book);

        Order order = Order.builder()
                .customer(customer)
                .book(book)
                .quantity(quantity)
                .orderDate(LocalDateTime.now())
                .build();

        return orderRepo.save(order);
    }

    public List<Order> getOrders() { return orderRepo.findAll(); }
}

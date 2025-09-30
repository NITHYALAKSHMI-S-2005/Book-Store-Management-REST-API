package com.example.bookstore.service;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.exception.ResourceNotFoundException;
import com.example.bookstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> getAllCustomers() { return repo.findAll(); }

    public Customer getCustomerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    public Customer createCustomer(Customer customer) { return repo.save(customer); }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = getCustomerById(id);
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        return repo.save(customer);
    }

    public void deleteCustomer(Long id) { repo.deleteById(id); }
}

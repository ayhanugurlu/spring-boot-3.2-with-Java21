package com.au.example.springboot32withjava21.client.jdbc.controller;

import com.au.example.springboot32withjava21.client.jdbc.Customer;
import com.au.example.springboot32withjava21.client.jdbc.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> list() {
        return customerRepository.list();
    }
}

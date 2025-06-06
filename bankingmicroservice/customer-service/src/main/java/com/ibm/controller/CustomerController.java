package com.ibm.controller;

import com.ibm.entity.Customer;
import com.ibm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Customer create(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping
    public List<Customer> all(){
        return customerService.getAll();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable long customerId) {
        return customerService.getBYId(customerId);
    }
}

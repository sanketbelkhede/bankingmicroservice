package com.ibm.service;

import com.ibm.dao.CustomerRepository;
import com.ibm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getBYId(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}

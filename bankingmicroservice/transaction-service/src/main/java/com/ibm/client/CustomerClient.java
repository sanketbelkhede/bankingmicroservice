package com.ibm.client;

import com.ibm.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/api/customers/{customerId}")
    public CustomerDto getCustomerById(@PathVariable("customerId") long customerId);
}

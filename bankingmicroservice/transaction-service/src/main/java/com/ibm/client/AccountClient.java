package com.ibm.client;

import com.ibm.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service")
public interface AccountClient {

    @GetMapping("/api/accounts/{accountId}")
    public AccountDto getAccountById(@PathVariable("accountId") long accountId);
}

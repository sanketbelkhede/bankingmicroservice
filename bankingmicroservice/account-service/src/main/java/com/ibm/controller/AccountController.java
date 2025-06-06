package com.ibm.controller;

import com.ibm.entity.Account;
import com.ibm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/save")
    public Account create(@RequestBody Account account) {
        return accountService.save(account);
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> getByCustomer(@PathVariable long customerId){
        return accountService.getAccountByCustomer(customerId);
    }

    public List<Account> all() {
        return accountService.getAll();
    }

    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable long accountId) {
        return accountService.getAccountById(accountId);
    }
}

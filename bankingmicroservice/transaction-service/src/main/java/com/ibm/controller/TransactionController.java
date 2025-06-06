package com.ibm.controller;

import com.ibm.entity.Transaction;
import com.ibm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public Transaction create(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @GetMapping
    public List<Transaction> all(){
        return transactionService.getAll();
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getByAccount(@PathVariable long accountId) {
        return transactionService.getByAccountId(accountId);
    }
}

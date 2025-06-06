package com.ibm.service;

import com.ibm.dao.AccountRepository;
import com.ibm.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAccountByCustomer(long customerId){
        return accountRepository.findByCustomerId(customerId);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}

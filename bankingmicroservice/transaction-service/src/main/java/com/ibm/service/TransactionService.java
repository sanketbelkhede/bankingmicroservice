package com.ibm.service;

import com.ibm.client.AccountClient;
import com.ibm.client.CustomerClient;
import com.ibm.dao.TransactionRepository;
import com.ibm.dto.AccountDto;
import com.ibm.dto.CustomerDto;
import com.ibm.dto.TransactionDto;
import com.ibm.dto.TransactionRequest;
import com.ibm.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private CustomerClient customerClient;

    public Transaction save(Transaction transaction) {
        transaction.setDateTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public List<Transaction> getByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public TransactionDto createTransaction(TransactionRequest transactionRequest) {
        AccountDto accountDto = accountClient.getAccountById(transactionRequest.getAccountId());

        CustomerDto customerDto = customerClient.getCustomerById(accountDto.getCustomerId());

        Transaction transaction = new Transaction();

        transaction.setType(transactionRequest.getType());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setAccountId(accountDto.getId());

        Transaction savedTx = transactionRepository.save(transaction);

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(savedTx.getId());
        transactionDto.setType(savedTx.getType());
        transactionDto.setAmount(savedTx.getAmount());
        transactionDto.setCustomerName(customerDto.getName());
        transactionDto.setAccountType(accountDto.getAccountType());

        return transactionDto;
    }
}

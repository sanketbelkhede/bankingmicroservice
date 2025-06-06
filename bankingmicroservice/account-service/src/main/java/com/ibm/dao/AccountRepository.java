package com.ibm.dao;

import com.ibm.entity.Account;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public List<Account> findByCustomerId(long customerId);
}

package com.ibm.dao;

import com.ibm.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
    Optional<UserData> findByUserName(String userName);
}

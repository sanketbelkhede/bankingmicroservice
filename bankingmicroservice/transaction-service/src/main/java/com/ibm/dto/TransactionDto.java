package com.ibm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private long id;
    private String type;
    private double amount;
    private String customerName;
    private String accountType;
}

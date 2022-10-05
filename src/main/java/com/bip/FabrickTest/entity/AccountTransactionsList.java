package com.bip.FabrickTest.entity;
import lombok.Data;


@Data
public class AccountTransactionsList {
    private String status;
    private String[] error;
    private TransactionsList payload;

}

package com.bip.FabrickTest.entity;
import lombok.Data;


@Data
public class AccountBalance {
    private String status;
    private String[] error;
    private AccountBalanceInfo payload;

}

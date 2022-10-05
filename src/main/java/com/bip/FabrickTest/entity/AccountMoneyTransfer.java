package com.bip.FabrickTest.entity;
import lombok.Data;


@Data
public class AccountMoneyTransfer {
    private String status;
    private String[] error;
    private TransferMoney payload;

}

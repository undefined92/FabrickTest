package com.bip.FabrickTest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AccountBalanceInfo {
    Date date;
    Double balance;
    Double availableBalance;
    String currency;
}

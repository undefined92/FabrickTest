package com.bip.FabrickTest.entity;
import lombok.Data;

import java.util.Date;


@Data
public class AmountInfo {
    private Double debtorAmount;
    private String debtorCurrency;
    private Double creditorAmount;
    private String creditorCurrency;
    private Date creditorCurrencyDate;
    private int exchangeRate;
}

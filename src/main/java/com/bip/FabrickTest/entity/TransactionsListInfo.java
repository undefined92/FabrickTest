package com.bip.FabrickTest.entity;
import lombok.Data;

import java.util.Date;


@Data
public class TransactionsListInfo {
    private String transactionId;
    private String operationId;
    private Date accountingDate;
    private Date valueDate;
    private TypeTransaction type;
    private String amount;
    private String currency;
    private String description;

}

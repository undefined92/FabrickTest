package com.bip.FabrickTest.entity;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class TransferMoney {
    private String moneyTransferId;
    private String status;
    private String direction;
    private CreditorInfo creditorInfo;
    private DebtorInfo debtorInfo;
    private String cro;
    private String uri;
    private String trn;
    private String description;
    private Date createdDatetime;
    private Date accountedDatetime;
    private Date debtorValueDate;
    private Date creditorValueDate;
    private AmountInfo amountInfoDTO;
    private boolean isUrgent;
    private boolean isInstant;
    private String feeType;
    private String feeAccountId;
    private List<FeesInfo> listfeesInfoDTO;
    private boolean hasTaxRelief;



}

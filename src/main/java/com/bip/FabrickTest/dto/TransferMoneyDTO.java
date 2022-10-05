package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class TransferMoneyDTO {
    @JsonProperty("moneyTransferId")
    private String moneyTransferId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("creditor")
    private CreditorInfoDTO creditor;
    @JsonProperty("debtor")
    private DebtorInfoDTO debtor;
    @JsonProperty("cro")
    private String cro;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("trn")
    private String trn;
    @JsonProperty("description")
    private String description;
    @JsonProperty("createdDatetime")
    private Date createdDatetime;
    @JsonProperty("accountedDatetime")
    private Date accountedDatetime;
    @JsonProperty("debtorValueDate")
    private Date debtorValueDate;
    @JsonProperty("creditorValueDate")
    private Date creditorValueDate;
    @JsonProperty("amount")
    private AmountInfoDTO amountInfoDTO;
    @JsonProperty("isUrgent")
    private boolean isUrgent;
    @JsonProperty("isInstant")
    private boolean isInstant;
    @JsonProperty("feeType")
    private String feeType;
    @JsonProperty("feeAccountId")
    private String feeAccountId;
    @JsonProperty("fees")
    private List<FeesInfoDTO> listfeesInfoDTO;
    @JsonProperty("hasTaxRelief")
    private boolean hasTaxRelief;



}

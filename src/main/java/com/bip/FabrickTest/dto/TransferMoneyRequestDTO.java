package com.bip.FabrickTest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class TransferMoneyRequestDTO implements Serializable {


    @JsonProperty("creditor")
    private CreditorInfoDTO creditor;
    @JsonProperty("executionDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date executionDate;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("description")
    private String description;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("isUrgent")
    private Boolean isUrgent;
    @JsonProperty("isInstant")
    private Boolean isInstant;
    @JsonProperty("feeType")
    private String feeType;
    @JsonProperty("feeAccountId")
    private String feeAccountId;
    @JsonProperty("taxRelief")
    private TaxReliefDTO taxRelief;

    public CreditorInfoDTO getCreditorInfo() {
        return creditor;
    }

    public void setCreditorInfo(CreditorInfoDTO creditor) {
        this.creditor = creditor;
    }

}

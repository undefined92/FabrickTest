package com.bip.FabrickTest.entity;

import java.io.Serializable;
import java.util.Date;

public class TransferMoneyRequest implements Serializable {
    public CreditorInfo getCreditorInfoDTO() {
        return creditorInfoDTO;
    }

    public void setCreditorInfoDTO(CreditorInfo creditorInfoDTO) {
        this.creditorInfoDTO = creditorInfoDTO;
    }

    private CreditorInfo creditorInfoDTO;
    private Date executionDate;
    private String uri;
    private String description;
    private Double amount;
    private String currency;
    private Boolean isUrgent;
    private Boolean isInstant;
    private String feeType;
    private String feeAccountId;
    private TaxRelief taxRelief;

}

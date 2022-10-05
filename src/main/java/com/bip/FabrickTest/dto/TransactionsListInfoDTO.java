package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
public class TransactionsListInfoDTO {
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("operationId")
    private String operationId;
    @JsonProperty("accountingDate")
    private Date accountingDate;
    @JsonProperty("valueDate")
    private Date valueDate;
    @JsonProperty("type")
    private TypeTransactionDTO type;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("description")
    private String description;

}

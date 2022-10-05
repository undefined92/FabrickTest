package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AccountTransactionsListDTO {
    @JsonProperty("status")
    private String status;
    @JsonProperty("error")
    private String[] error;
    @JsonProperty("payload")
    private TransactionsListDTO payload;

}

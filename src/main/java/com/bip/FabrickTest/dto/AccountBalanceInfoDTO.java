package com.bip.FabrickTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AccountBalanceInfoDTO {
    @JsonProperty("date")
    Date date;
    @JsonProperty("balance")
    Double balance;
    @JsonProperty("availableBalance")
    Double availableBalance;
    @JsonProperty("currency")
    String currency;
}

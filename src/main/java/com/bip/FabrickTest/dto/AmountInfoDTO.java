package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
public class AmountInfoDTO {
    @JsonProperty("debtorAmount")
    private Double debtorAmount;
    @JsonProperty("debtorCurrency")
    private String debtorCurrency;
    @JsonProperty("creditorAmount")
    private Double creditorAmount;
    @JsonProperty("creditorCurrency")
    private String creditorCurrency;
    @JsonProperty("creditorCurrencyDate")
    private Date creditorCurrencyDate;
    @JsonProperty("exchangeRate")
    private int exchangeRate;
}

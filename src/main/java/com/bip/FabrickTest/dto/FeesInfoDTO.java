package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class FeesInfoDTO {
    @JsonProperty("feeCode")
    private String feeCode;
    @JsonProperty("description")
    private String description;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("currency")
    private String currency;
}

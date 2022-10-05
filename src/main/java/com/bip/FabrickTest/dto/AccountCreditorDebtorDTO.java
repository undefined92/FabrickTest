package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AccountCreditorDebtorDTO {
    @JsonProperty("accountCode")
    private String accountCode;
    @JsonProperty("bicCode")
    private String bicCode;
}

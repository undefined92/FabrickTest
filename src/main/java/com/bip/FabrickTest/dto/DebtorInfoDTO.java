package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class DebtorInfoDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("account")
    private AccountCreditorDebtorDTO accountCreditorDebtorDTO;
}

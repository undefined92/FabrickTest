package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class CreditorInfoDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("account")
    private AccountCreditorDebtorDTO account;
    @JsonProperty("address")
    private AddressCreditorDTO address;
}

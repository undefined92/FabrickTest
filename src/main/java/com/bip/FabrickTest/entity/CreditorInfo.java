package com.bip.FabrickTest.entity;
import lombok.Data;


@Data
public class CreditorInfo {
    public void setName(String name) {
        this.name = name;
    }

    public void setAccountCreditorDebtorDTO(AccountCreditorDebtor accountCreditorDebtorDTO) {
        AccountCreditorDebtorDTO = accountCreditorDebtorDTO;
    }

    public void setAddressCreditorDTO(AddressCreditor addressCreditorDTO) {
        this.addressCreditorDTO = addressCreditorDTO;
    }

    private String name;
    private AccountCreditorDebtor AccountCreditorDebtorDTO;
    private AddressCreditor addressCreditorDTO;
}

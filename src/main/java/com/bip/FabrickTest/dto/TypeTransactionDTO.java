package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class TypeTransactionDTO {
    @JsonProperty("enumeration")
    private String enumeration;
    @JsonProperty("value")
    private String value;
}

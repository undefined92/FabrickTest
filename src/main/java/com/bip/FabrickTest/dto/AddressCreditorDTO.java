package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AddressCreditorDTO {
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("countryCode")
    private int countryCode;
}

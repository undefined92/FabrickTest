package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class LegalPersonBeneficiaryDTO {
    @JsonProperty("fiscalCode")
    private String fiscalCode;
    @JsonProperty("legalRepresentativeFiscalCode")
    private String legalRepresentativeFiscalCode;

}

package com.bip.FabrickTest.entity;
import lombok.Data;


@Data
public class TaxRelief {
    private String taxReliefId;
    private Boolean isCondoUpgrade;
    private String creditorFiscalCode;
    private String beneficiaryType;
    private NaturalPersonBeneficiary naturalPersonBeneficiary;
    private LegalPersonBeneficiary legalPersonBeneficiary;
}

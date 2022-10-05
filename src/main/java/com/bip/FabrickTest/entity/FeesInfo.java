package com.bip.FabrickTest.entity;
import lombok.Data;


@Data
public class FeesInfo {
    private String feeCode;
    private String description;
    private Double amount;
    private String currency;
}

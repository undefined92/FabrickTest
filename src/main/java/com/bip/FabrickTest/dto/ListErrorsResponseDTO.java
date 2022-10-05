package com.bip.FabrickTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListErrorsResponseDTO {
    @JsonProperty("code")
    private String code;
    @JsonProperty("description")
    private String description;
    @JsonProperty("params")
    private String params;
}

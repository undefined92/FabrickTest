package com.bip.FabrickTest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class TransactionsListDTO {
    @JsonProperty("list")
    private List<TransactionsListInfoDTO> list;
}

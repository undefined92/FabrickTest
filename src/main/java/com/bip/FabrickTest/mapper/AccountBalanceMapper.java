package com.bip.FabrickTest.mapper;

import com.bip.FabrickTest.dto.AccountBalanceDTO;
import com.bip.FabrickTest.entity.AccountBalance;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AccountBalanceMapper extends EntityMapper<AccountBalanceDTO, AccountBalance> {
    @Override
    AccountBalance toEntity(AccountBalanceDTO dto);
}

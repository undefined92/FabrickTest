package com.bip.FabrickTest.mapper;

import com.bip.FabrickTest.dto.AccountTransactionsListDTO;
import com.bip.FabrickTest.entity.AccountTransactionsList;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AccountTransactionsListMapper extends EntityMapper<AccountTransactionsListDTO, AccountTransactionsList> {
    @Override
    AccountTransactionsList toEntity(AccountTransactionsListDTO dto);
}

package com.bip.FabrickTest.mapper;

import com.bip.FabrickTest.dto.AccountMoneyTransferDTO;
import com.bip.FabrickTest.entity.AccountMoneyTransfer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AccountTransferMoneyMapper extends EntityMapper<AccountMoneyTransferDTO, AccountMoneyTransfer> {
    @Override
    AccountMoneyTransfer toEntity(AccountMoneyTransferDTO dto);
}


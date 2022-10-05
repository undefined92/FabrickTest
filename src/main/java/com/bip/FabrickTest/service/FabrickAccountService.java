package com.bip.FabrickTest.service;

import com.bip.FabrickTest.dto.*;
import com.bip.FabrickTest.entity.AccountBalance;
import com.bip.FabrickTest.entity.AccountMoneyTransfer;
import com.bip.FabrickTest.entity.AccountTransactionsList;
import com.bip.FabrickTest.mapper.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class FabrickAccountService {
    @Autowired
    private DataTransferService dataTransfer;

    @Autowired
    private AccountTransferMoneyMapper accountTransferMoneyMapper;

    @Autowired
    private AccountBalanceMapper accountBalanceMapper;

    @Autowired
    private AccountTransactionsListMapper accountTransactionsListMapper;

    @Value("${endpoint.urlBalanceAccount}")
    private String urlGetBalance;

    @Value("${endpoint.urlCreateMoneyTransfer}")
    private String urlCreateMoneyTransfer;

    @Value("${endpoint.urlTransactionsList}")
    private String urlTransactionsList;

    public FabrickAccountService(){
    }

    @ApiOperation(value = "Get Balance Account")
    public AccountBalance getCashAccountById(Long accountId) {
        URI urlClient = UriComponentsBuilder.fromUri(URI.create(String.format(urlGetBalance, accountId))).build().toUri();
        AccountBalanceDTO accountBalanceDTO = dataTransfer.getBalance(urlClient);
        AccountBalance accountBalance = accountBalanceMapper.toEntity(accountBalanceDTO);
        return accountBalance;
    }

    @ApiOperation(value = "Create Money Transfer")
    public AccountMoneyTransfer createMoneyTransfer(Long accountId, TransferMoneyRequestDTO transferMoneyRequestDTO)  {
        URI urlClient = UriComponentsBuilder.fromUri(URI.create(String.format(urlCreateMoneyTransfer, accountId))).build().toUri();
        AccountMoneyTransferDTO accountTransferMoneyDTO= dataTransfer.createMoneyTransfer(urlClient, transferMoneyRequestDTO);
        AccountMoneyTransfer accountMoneyTransfer = accountTransferMoneyMapper.toEntity(accountTransferMoneyDTO);
        return accountMoneyTransfer;
    }

    @ApiOperation(value = "Get Transactions List")
    public AccountTransactionsList getTransactionsList(Long accountId, String fromAccountingDate, String toAccountingDate) {
        URI urlClient = UriComponentsBuilder.fromUri(URI.create(String.format(urlTransactionsList, accountId)))
                .queryParam("fromAccountingDate", fromAccountingDate)
                .queryParam("toAccountingDate", toAccountingDate).build().toUri();

        AccountTransactionsListDTO accountTransactionsListDTO = dataTransfer.getTransactionsList(urlClient);
        AccountTransactionsList accountTransactionsList = accountTransactionsListMapper.toEntity(accountTransactionsListDTO);
        return accountTransactionsList;
    }



}

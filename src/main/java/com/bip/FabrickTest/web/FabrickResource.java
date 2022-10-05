package com.bip.FabrickTest.web;


import com.bip.FabrickTest.dto.TransferMoneyRequestDTO;
import com.bip.FabrickTest.entity.AccountBalance;
import com.bip.FabrickTest.entity.AccountMoneyTransfer;
import com.bip.FabrickTest.entity.AccountTransactionsList;
import com.bip.FabrickTest.service.FabrickAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api-fabrick")
public class FabrickResource {

    @Autowired
    private FabrickAccountService fabrickAccountService;


    @GetMapping("/getCashAccount/{accountId}")
    public ResponseEntity<AccountBalance> getCashAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok().body(fabrickAccountService.getCashAccountById(accountId));
    }

    @PostMapping("/createMoneyTransfer/{accountId}")
    public ResponseEntity<AccountMoneyTransfer> createMoneyTransfer(@PathVariable Long accountId, @RequestBody TransferMoneyRequestDTO transferMoneyRequestDTO)  {
        return ResponseEntity.ok().body(fabrickAccountService.createMoneyTransfer(accountId, transferMoneyRequestDTO));
    }

    @GetMapping("/getTransactionsList/{accountId}")
    public ResponseEntity<AccountTransactionsList> getTransactionsList(@PathVariable Long accountId, @RequestParam(required = true) String fromAccountingDate,
                                                                       @RequestParam(required = true) String toAccountingDate)  {
        return ResponseEntity.ok().body(fabrickAccountService.getTransactionsList(accountId, fromAccountingDate, toAccountingDate));
    }




}

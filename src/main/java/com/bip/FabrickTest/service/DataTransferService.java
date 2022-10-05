package com.bip.FabrickTest.service;

import com.bip.FabrickTest.dto.*;
import com.bip.FabrickTest.util.ClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class DataTransferService {

    private static final String KO = "KO";

    @Autowired
    private ClientUtil clientUtil;

    public AccountBalanceDTO getBalance(URI urlClient) {
        HttpEntity<Void> entity = new HttpEntity<>(clientUtil.buildHeaders());
        System.out.println(urlClient);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountBalanceDTO> responseEntity = null;
        try{
            responseEntity = restTemplate.exchange(urlClient, HttpMethod.GET, entity, AccountBalanceDTO.class);
        }catch(HttpClientErrorException e){
            AccountBalanceDTO error = new AccountBalanceDTO();
            error.setStatus(KO);
            error.setError(new String[]{e.getMessage(), Integer.toString(e.getRawStatusCode()), e.getStatusText(),});
            return error;
        }catch (Exception e){
            AccountBalanceDTO error = new AccountBalanceDTO();
            error.setStatus(KO);
            error.setError(new String[]{e.getMessage()});
            return error;
        }

        return responseEntity.getBody();

    }


    public AccountMoneyTransferDTO createMoneyTransfer(URI urlClient, TransferMoneyRequestDTO transferMoneyRequestDTO) {
        HttpEntity<TransferMoneyRequestDTO> entity = new HttpEntity<>(transferMoneyRequestDTO, clientUtil.buildHeaders());
        System.out.println(urlClient);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountMoneyTransferDTO> responseEntity = null;
        try{
            responseEntity = restTemplate.postForEntity(urlClient, entity, AccountMoneyTransferDTO.class);
        }catch(HttpClientErrorException e){
            AccountMoneyTransferDTO error = new AccountMoneyTransferDTO();
            error.setStatus(KO);
            error.setError(new String[]{e.getMessage(), Integer.toString(e.getRawStatusCode()), e.getStatusText(),});
            return error;
        }catch (Exception e){
            AccountMoneyTransferDTO error = new AccountMoneyTransferDTO();
            error.setStatus(KO);
            error.setError(new String[]{e.getMessage()});
            return error;
        }
        return responseEntity.getBody();
    }

    public AccountTransactionsListDTO getTransactionsList(URI urlClient) {
        HttpEntity<Void> entity = new HttpEntity<>(clientUtil.buildHeaders());
        System.out.println(urlClient);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountTransactionsListDTO> responseEntity = null;
        try{
            responseEntity = restTemplate.exchange(urlClient, HttpMethod.GET, entity, AccountTransactionsListDTO.class);
        }catch(HttpClientErrorException e){
            AccountTransactionsListDTO error = new AccountTransactionsListDTO();
            error.setStatus(KO);
            error.setError(new String[]{e.getMessage(), Integer.toString(e.getRawStatusCode()), e.getStatusText(),});
            return error;
        }catch (Exception e){
            AccountTransactionsListDTO error = new AccountTransactionsListDTO();
            error.setStatus(KO);
            error.setError(new String[]{e.getMessage()});
            return error;
        }
        return responseEntity.getBody();

    }
}

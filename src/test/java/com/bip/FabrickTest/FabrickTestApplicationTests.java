package com.bip.FabrickTest;

import com.bip.FabrickTest.dto.*;
import com.bip.FabrickTest.entity.AccountBalance;
import com.bip.FabrickTest.entity.AccountMoneyTransfer;
import com.bip.FabrickTest.entity.AccountTransactionsList;
import com.bip.FabrickTest.util.ClientUtil;
import com.bip.FabrickTest.web.FabrickResource;
import com.google.gson.Gson;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Objects;

@SpringBootTest
class FabrickTestApplicationTests {
	@Autowired
	FabrickResource fabrickResource;

	private ClientUtil clientUtil = new ClientUtil();

	@Test
	void getBalance() throws IOException {
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		HttpEntity<Void> entity = new HttpEntity<>(clientUtil.buildHeaders());
		String balanceResponse = new String(Files.readAllBytes(Paths.get("ResponseBalance.json")));

		//recupero la response dall'API di Fabrick
		ResponseEntity<AccountBalanceDTO> accountBalanceResponseEntity = ResponseEntity.ok(new Gson().fromJson(String.valueOf(balanceResponse), AccountBalanceDTO.class));
		URI urlClient = UriComponentsBuilder.fromUri(URI.create("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/14537780/balance")).build().toUri();
		Mockito.when(restTemplate.exchange(urlClient, HttpMethod.GET, entity, AccountBalanceDTO.class))
				.thenReturn(accountBalanceResponseEntity);

		//recupero la response dall'API creata
		ResponseEntity<AccountBalance> myResponse = fabrickResource.getCashAccount(14537780L);

		//verifico che le due response hanno il valore 'availableBalance' uguale
		Assertions.assertEquals(new Double("-7.87"), Objects.requireNonNull(myResponse.getBody().getPayload().getAvailableBalance()));
	}

	@Test
	void getTransactionsList() throws IOException {
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		HttpEntity<Void> entity = new HttpEntity<>(clientUtil.buildHeaders());
		String accountTransactionsList = new String(Files.readAllBytes(Paths.get("ResponseTransactionsList.json")));

		//recupero la response dall'API di Fabrick
		ResponseEntity<AccountTransactionsListDTO> accountTransactionsResponseEntity = ResponseEntity.ok(new Gson().fromJson(String.valueOf(accountTransactionsList), AccountTransactionsListDTO.class));
		URI urlClient = UriComponentsBuilder.fromUri(URI.create("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/14537780/transactions?fromAccountingDate=2019-01-01&toAccountingDate=2019-04-01")).build().toUri();
		Mockito.when(restTemplate.exchange(urlClient, HttpMethod.GET, entity, AccountTransactionsListDTO.class))
				.thenReturn(accountTransactionsResponseEntity);

		//recupero la response dall'API creata
		ResponseEntity<AccountTransactionsList> myResponse = fabrickResource.getTransactionsList(14537780L, "2019-01-01", "2019-04-01");

		//verifico che le due response hanno lo stesso numero di transazioni e gli stessi transaction id
		Assertions.assertEquals(Objects.requireNonNull(accountTransactionsResponseEntity.getBody().getPayload().getList().size()), Objects.requireNonNull(myResponse.getBody().getPayload().getList().size()));
		for(int i=0; i<1;i++){
			Assertions.assertEquals(Objects.requireNonNull(accountTransactionsResponseEntity.getBody().getPayload().getList().get(i).getTransactionId()), Objects.requireNonNull(myResponse.getBody().getPayload().getList().get(i).getTransactionId()));
		}
	}

	@Test
	void TransferMoney() throws IOException, ParseException {
		String request = new String(Files.readAllBytes(Paths.get("RequestTransferMoney.json")));

		//recupero la response dall'API di Fabrick
		ResponseEntity<TransferMoneyRequestDTO> transferMoneyEntity = ResponseEntity.ok(new Gson().fromJson(String.valueOf(request), TransferMoneyRequestDTO.class));
		TransferMoneyRequestDTO transferMoneyRequestDTO = new Gson().fromJson(request, TransferMoneyRequestDTO.class);
		HttpEntity<TransferMoneyRequestDTO> entity = new HttpEntity<>(transferMoneyRequestDTO, clientUtil.buildHeaders());
		URI urlClient = UriComponentsBuilder.fromUri(URI.create("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/14537780/payments/money-transfers")).build().toUri();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AccountMoneyTransferDTO> fabrickResponse = null;
		String errorMessage = "";
		try{
			fabrickResponse =  restTemplate.postForEntity(urlClient, entity, AccountMoneyTransferDTO.class);
		}catch(HttpClientErrorException e){
			errorMessage = e.getMessage();
		}

		//recupero la response dall'API creata
		ResponseEntity<AccountMoneyTransfer> myResponse = fabrickResource.createMoneyTransfer(14537780L, transferMoneyRequestDTO);

		//verifico che le due response presentano lo stesso errore
		Assertions.assertEquals(errorMessage, Objects.requireNonNull(myResponse.getBody().getError()[0]));
	}

}

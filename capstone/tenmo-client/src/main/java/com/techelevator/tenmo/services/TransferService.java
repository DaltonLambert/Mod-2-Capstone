package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.util.BasicLogger;
import io.cucumber.java.bs.A;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class TransferService {

  /*  public static final String API_BASE_URL = "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {this.authToken = authToken;}

    public Transfer[] getAllTransfers() {
        Transfer[] allTransfers = null;
        try {
            ResponseEntity<Transfer[]> response = restTemplate.exchange(
                    API_BASE_URL + "/transfer", HttpMethod.GET, makeAuthEntity(), Transfer[].class);
            allTransfers = response.getBody();
        } catch (RestClientException e) {
            BasicLogger.log(e.getMessage());
        } return allTransfers;
    }

    public Transfer createTransfer(Transfer transfer) {
        Transfer transferCreated = null;
        try {
            ResponseEntity<Transfer> response = restTemplate.exchange(
                    API_BASE_URL + "/transfer", HttpMethod.POST, makeTransferEntity(transfer), Transfer.class);
            transferCreated = response.getBody();
        } catch (RestClientException e) {
            BasicLogger.log(e.getMessage());
        } return transferCreated;
    }

    public Transfer[] getPendingTransfers(int id) {
        Transfer[] pendingTransfers = null;
        try {
            ResponseEntity<Transfer[]> response = restTemplate.exchange(
                    API_BASE_URL + "/transfer" + "/pending" + id, HttpMethod.GET, makeAuthEntity(), Transfer[].class);
            pendingTransfers = response.getBody();
        } catch (RestClientException e) {
            BasicLogger.log(e.getMessage());
        } return pendingTransfers;
    }





    private HttpEntity<Account> makeTransferEntity(Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity(transfer, headers);
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }
}
*/
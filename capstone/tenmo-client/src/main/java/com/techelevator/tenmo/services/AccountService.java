package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class AccountService {

  /*  public static final String API_BASE_URL = "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {this.authToken = authToken;}

    public BigDecimal getBalance(int user_id){
        BigDecimal balance = null;
        try {
            ResponseEntity<BigDecimal> response = restTemplate.exchange(
                    API_BASE_URL + "account/" + "user/" + user_id + "balance", HttpMethod.GET, makeAuthEntity(), BigDecimal.class);
            balance = response.getBody();
        }
        catch (RestClientException e){
            BasicLogger.log(e.getMessage());
        } return balance;
    }
    public Account getAccountByUserId(int userId) {
        Account account = null;
        try {
            ResponseEntity<Account> response = restTemplate.exchange(
                    API_BASE_URL + "account/" + "user" + userId, HttpMethod.GET, makeAuthEntity(), Account.class);
            account = response.getBody();
        } catch (RestClientException e) {
            BasicLogger.log(e.getMessage());
        } return account;
    }

    public void sendTeBucks(int senderId, int receiverId, BigDecimal amount){
        try {
            ResponseEntity<Void> response = restTemplate.exchange(API_BASE_URL + "send/" + senderId + "/" + receiverId + "/" + amount,
                    HttpMethod.POST, makeAuthEntity(), Void.class);
        } catch (RestClientException e) {
            BasicLogger.log(e.getMessage());
        }
    }

    public void receiveTeBucks(int receiverId, int senderId, BigDecimal amount) {
        try {
            ResponseEntity<Void> response = restTemplate.exchange(
                    API_BASE_URL + "receive/" + receiverId + "/" + senderId + "/" + amount,
                    HttpMethod.POST, makeAuthEntity(), Void.class);
        } catch (RestClientException e) {
            BasicLogger.log(e.getMessage());
        }
    }

    private HttpEntity<Account> makeAccountEntity(Account account) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(account, headers);
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

}
   */

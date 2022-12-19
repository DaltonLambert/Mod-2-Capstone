package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    Account getAccount();

    BigDecimal getBalance(int userId);

    List<Account> findAll();

    Account getAccountByAccountId(int accountId);

    Account findAccountByUserId(int userId);

    Account updateAccountBalance(int userId, BigDecimal amount) ;

    Account createAccount (Account account);

    void deleteAccount (int id);

    BigDecimal getBalanceByUserId (int id);

    BigDecimal getBalanceByAccountId (int id);

    Account addToAccount (Account account, int id, BigDecimal amount);

    Account subtractFromAccount (Account account, int id, BigDecimal amount);

  /*  void sendTeBucks (int sender, int receiver, BigDecimal amount);

    void receiveTeBucks (int receiver, int sender, BigDecimal amount);
*/



}



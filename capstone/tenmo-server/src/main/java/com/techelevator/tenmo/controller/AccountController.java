package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountDao accountDao;

    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public Account getAccount(){ return accountDao.getAccount(); }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public Account getAccountByAccountId(@PathVariable int accountId){return accountDao.getAccountByAccountId(accountId);}

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public Account findAccountByUserId(@PathVariable int userId){return accountDao.findAccountByUserId(userId);}

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Account> findAll(){return accountDao.findAll();}


    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public Account updateAccountBalance(@PathVariable int userId, @RequestBody BigDecimal amount){return accountDao.updateAccountBalance(userId, amount);}

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable int id){accountDao.deleteAccount(id);}

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account){return accountDao.createAccount(account);}

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Account addToAccount(@RequestBody Account account, BigDecimal balance, @PathVariable int id){return accountDao.addToAccount(account, id, balance);}
//Does order matter
    @RequestMapping(value = "/balance/users/{id}", method = RequestMethod.GET)
    public BigDecimal getBalance(@PathVariable int userId){return accountDao.getBalance(userId);}

    @RequestMapping(value = "/balance/{id}", method = RequestMethod.GET)
    public BigDecimal getBalanceByAccountId(@PathVariable int id){return accountDao.getBalanceByAccountId(id);}

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Account subtractFromAccount(@RequestBody Account account, BigDecimal amount, @PathVariable int id){return accountDao.subtractFromAccount(account, id, amount);}

  /*  @RequestMapping(value = "/{sender}/{receiver}/amount", method = RequestMethod.PUT)
    public void sendTeBucks(@PathVariable int accountTo, int accountFrom, BigDecimal amount){accountDao.sendTeBucks(accountTo, accountFrom, amount);}

    @RequestMapping(value = "/{receiver}/{sender}/amount", method = RequestMethod.POST)
    public void receiveTeBucks(@PathVariable int accountFrom, int accountTo,BigDecimal amount){accountDao.receiveTeBucks(accountFrom, accountTo, amount);}
*/
}

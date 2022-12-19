package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccount() {
        Account account = null;

        String sql = "SELECT account_id, user_id, balance FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, user_id, balance FROM account;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Account account = mapRowToAccount(results);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public Account getAccountByAccountId(int accountId) {

        String sql = "SELECT account_id, user_id, balance FROM account WHERE account_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if (results.next()) {
            return mapRowToAccount(results);
        } else {
            return null;
        }
    }

    @Override
    public Account findAccountByUserId(int userId) {
        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        if (rowSet.next()) {
            return mapRowToAccount(rowSet);
        } else{
            return null;
        }
    }

    @Override
    public Account updateAccountBalance(int userId, BigDecimal amount) {
        BigDecimal updatedBalance = getBalance(userId).add(amount);
        String sql =
                "UPDATE account SET balance = ? WHERE user_id = ? ;";
        jdbcTemplate.update(sql,updatedBalance, userId);
        return getAccount();
    }

    @Override
    public Account createAccount(Account account) {

        String sql = "INSERT INTO account (user_id, balance)" +
                "Values (?,?) Returning account_id";
        int newId = jdbcTemplate.queryForObject(sql, int.class, account.getUser_id(), account.getBalance());
        return findAccountByUserId(newId);
    }

    @Override
    public void deleteAccount(int id) {

        String sql = "DELETE from account where account_id = ?;";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public BigDecimal getBalance(int userId) {
        BigDecimal balance = null;

        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if(results.next()) {
            balance = mapRowToAccount(results).getBalance();
        }
        return balance;
    }

    @Override
    public BigDecimal getBalanceByUserId(int id) {
        return findAccountByUserId(id).getBalance();
    }

    @Override
    public BigDecimal getBalanceByAccountId(int id) {
        return getAccountByAccountId(id).getBalance();
    }

    @Override
    public Account addToAccount(Account account, int id, BigDecimal amount) {

        String sql = "UPDATE account set balance = ? where account_id = ?;";

        BigDecimal newBalance = getBalanceByAccountId(id).add(amount);

        jdbcTemplate.update(sql, newBalance, id);
        return getAccountByAccountId(id);
    }

    @Override
    public Account subtractFromAccount(Account account, int id, BigDecimal amount) {

        String sql = "UPDATE account set balance ? where account_id = ?;";

        BigDecimal newB = getBalanceByAccountId(id).subtract(amount);
        jdbcTemplate.update(sql, newB, id);
        return getAccountByAccountId(id);
    }

   /* @Override
    public void sendTeBucks(int sender, int receiver, BigDecimal amount) {
        subtractFromAccount(sender, amount);
        addToAccount(receiver, amount);
    }

    @Override
    public void receiveTeBucks(int receiver, int sender, BigDecimal amount) {
        subtractFromAccount(sender, amount);
        addToAccount(receiver, amount);
    }
    */


    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setAccount_id(rs.getInt("account_id"));
        account.setUser_id(rs.getInt("user_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        return account;
    }
}

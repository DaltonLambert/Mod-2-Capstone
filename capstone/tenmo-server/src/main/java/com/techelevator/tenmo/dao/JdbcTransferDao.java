package com.techelevator.tenmo.dao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {

    private final JdbcTemplate jdbcTemplate;

    private AccountDao accountDao;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Transfer getTransfersByTransferId(int transferId) {
        String sql = "SELECT * FROM transfers WHERE transfer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
        if (results.next()) {
            return mapRowToTransfer(results);
        } else {
            return null;
        }
    }

    @Override
    public Transfer getTransfersByUserId(int userId) {
        return null;
    }

    @Override
    public Transfer getTransfersByAccountId(int accountId) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT * FROM transfers WHERE  = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, getTransfersByAccountId(accountId));
        if (results.next()) {
            return mapRowToTransfer(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Transfer> findAll() {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT * FROM transfer";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Transfer transfer = mapRowToTransfer(results);
            transfers.add(transfer);
        }

        return transfers;
    }

    @Override
    public Account addToAccount(int id, BigDecimal amount) {
        return null;
    }

    @Override
    public Account subtractFromAccount(int id, BigDecimal amount) {
        return null;
    }

    @Override
    public void sendTeBucks( Transfer transfer, int senderUserId, int receiverUserId, BigDecimal amount) {
        BigDecimal senderBalance = accountDao.getBalance(senderUserId);
       if (senderUserId == receiverUserId){
           System.out.println("Sending and receiving accounts cannot be the same");
       } else if (senderBalance.compareTo(amount) < 0){
           System.out.println("Insufficient Funds");
       }


        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES (?,?,?,?,?);";

        jdbcTemplate.update(sql, transfer.getTransfer_type_id(),transfer.getTransfer_status_id(),
                transfer.getAccount_from(), transfer.getAccount_to(), transfer.getAmount());

        subtractFromAccount(senderUserId, amount);
        addToAccount(receiverUserId, amount);

        System.out.println("Transfer was successful");
    }

    @Override
    public void requestTeBucks(Transfer transfer, int senderUserId, int receiverUserId, BigDecimal amount) {
        BigDecimal senderBalance = accountDao.getBalance(senderUserId);
        if (senderUserId == receiverUserId){
            System.out.println("Sending and receiving accounts cannot be the same");
        } else if (senderBalance.compareTo(amount) < 0){
            System.out.println("Insufficient Funds");
        }
        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES (?,?,?,?,?);";

        jdbcTemplate.update(sql, transfer.getTransfer_type_id(),transfer.getTransfer_status_id(),
                transfer.getAccount_from(), transfer.getAccount_to(), transfer.getAmount());

        subtractFromAccount(senderUserId, amount);
        addToAccount(receiverUserId, amount);

        System.out.println("Transfer was successful");
    }


    private Transfer mapRowToTransfer(SqlRowSet results) {
        Transfer transfer = new Transfer();
        transfer.setTransfer_id(results.getInt("transfer_id"));
        transfer.setTransfer_type_id(results.getInt("transfer_type_id"));
        transfer.setTransfer_status_id(results.getInt("transfer_status_id"));
        transfer.setAccount_from(results.getInt("account_from"));
        transfer.setAccount_to(results.getInt("account_to"));
        transfer.setAmount(results.getBigDecimal("amount"));

        return transfer;


    }
}

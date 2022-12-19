package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {

    Transfer getTransfersByTransferId(int transferId);

    Transfer getTransfersByUserId(int userId);

    Transfer getTransfersByAccountId(int accountId);

    List<Transfer> findAll();

    Account addToAccount (int id, BigDecimal amount);

    Account subtractFromAccount (int id, BigDecimal amount);

    void sendTeBucks (Transfer transfer, int senderUserId, int receiverUserId, BigDecimal amount);

    void requestTeBucks (Transfer transfer, int senderUserId, int receiverUserId, BigDecimal amount);



}



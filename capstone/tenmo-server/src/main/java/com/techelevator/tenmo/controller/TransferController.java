package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.yaml.snakeyaml.events.Event;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private TransferDao transferDao;

    public TransferController(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Transfer getTransfersByTransferId(@PathVariable int transferId){return transferDao.getTransfersByTransferId(transferId);}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Transfer getTransfersByUserId(@PathVariable int id){return transferDao.getTransfersByUserId(id);}

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Transfer> findAll(){return transferDao.findAll();}

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/sendTeBucks", method = RequestMethod.POST)
    public void sendTeBucks(@RequestBody Transfer transfer, Long senderUserId, Long receiverUserId, BigDecimal amount)
    {transferDao.sendTeBucks(transfer, Math.toIntExact(senderUserId), Math.toIntExact(receiverUserId), amount);}

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/requestTeBucks", method = RequestMethod.POST)
    public void requestTeBucks(@RequestBody Transfer transfer, Long receiverUserId, Long senderUserId, BigDecimal amount)
    {transferDao.requestTeBucks(transfer, Math.toIntExact(receiverUserId), Math.toIntExact(senderUserId), amount);}
}

package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.TransferMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Transfer;

@Service
public class TransferService {

    private final TransferMapper transferMapper;

    public TransferService(TransferMapper transferMapper) {
        this.transferMapper = transferMapper;
    }

    public List<Transfer> getAllTransfers() {
        return transferMapper.getAllTransfers();
    }

    public Transfer getTransferById(Long transferId) {
        return transferMapper.getTransferById(transferId);
    }

    public int createTransfer(Transfer transfer) {
        return transferMapper.insert(transfer);
    }
}
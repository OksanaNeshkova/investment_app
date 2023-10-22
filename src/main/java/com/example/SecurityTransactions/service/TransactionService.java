package com.example.SecurityTransactions.service;

import com.example.SecurityTransactions.entity.Share;
import com.example.SecurityTransactions.entity.Transaction;
import com.example.SecurityTransactions.repo.ShareRepository;
import com.example.SecurityTransactions.repo.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService (TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }
    public Transaction addTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

}

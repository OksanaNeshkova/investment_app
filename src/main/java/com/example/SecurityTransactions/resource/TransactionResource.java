package com.example.SecurityTransactions.resource;


import com.example.SecurityTransactions.entity.Share;
import com.example.SecurityTransactions.entity.Transaction;
import com.example.SecurityTransactions.service.ShareService;
import com.example.SecurityTransactions.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionResource {
    private final TransactionService transactionService;

    public TransactionResource (TransactionService transactionService){
        this.transactionService = transactionService;
    }
    @GetMapping("/all")
    public List<Transaction> getAllTransaction() {
        return transactionService.findAllTransactions();
    }

    @PostMapping("/add")
    public void addTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
    }

}

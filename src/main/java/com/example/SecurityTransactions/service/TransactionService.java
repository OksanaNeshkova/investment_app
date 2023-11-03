package com.example.SecurityTransactions.service;

import com.example.SecurityTransactions.entity.*;
import com.example.SecurityTransactions.exception.ShortSellingNotAllowedException;
import com.example.SecurityTransactions.exception.TransactionNotFoundException;
import com.example.SecurityTransactions.repo.EmployeeRepository;
import com.example.SecurityTransactions.repo.ShareRepository;
import com.example.SecurityTransactions.repo.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final EmployeeRepository employeeRepository;
    private final ShareRepository shareRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, EmployeeRepository employeeRepository, ShareRepository shareRepository) {
        this.transactionRepository = transactionRepository;
        this.employeeRepository = employeeRepository;
        this.shareRepository = shareRepository;
    }

    public List<Transaction> findAllTransactions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return transactionRepository.findAll();
    }

    public Transaction addTransaction(Transaction transaction, Long empId, Long secId) {

        if (transaction.getType() == TransactionType.SALE) {
            long amount = shareBalance(secId);
            if (amount < transaction.getVolume()) {
                throw new ShortSellingNotAllowedException("Insufficient amount of shares, please check your portfolio balance");
            }
        }
        Employee emp = employeeRepository.findById(empId).get();
        transaction.setEmployee(emp);
        Share share = shareRepository.findById(secId).get();
        transaction.setShare(share);
        emp.getTransaction().add(transaction);
        share.getStockTransactions().add(transaction);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {

            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                System.out.println(userDetails.getUsername());
                System.out.println(userDetails.getAuthorities());
            } else {
                System.out.println("Principal is not an instance of UserDetails, handle accordingly");
            }
        } else {
            System.out.println("User is not authenticated, handle accordingly");
        }
        return transactionRepository.save(transaction);
    }

    public long shareBalance(Long secId) {
        long shareBalance = 0;
        List<Transaction> transactions = shareRepository.findById(secId).get().getStockTransactions();
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getType() == TransactionType.PURCHASE) {
                shareBalance += transactions.get(i).getVolume();
            } else {
                shareBalance -= transactions.get(i).getVolume();
            }
        }
        return shareBalance;
    }

    public Transaction updateTransaction(Transaction transaction) {
        Share share = findTransactionById(transaction.getId()).getShare();
        Employee employee = findTransactionById(transaction.getId()).getEmployee();
        Transaction foundTransaction = findTransactionById(transaction.getId());
        long currentBalance = shareBalance(share.getId());
        if (foundTransaction.getType() == TransactionType.PURCHASE && transaction.getType() == TransactionType.PURCHASE) {
            currentBalance = currentBalance + (transaction.getVolume() - foundTransaction.getVolume());
        } else if (foundTransaction.getType() == TransactionType.PURCHASE && transaction.getType() == TransactionType.SALE) {
            currentBalance = currentBalance - (foundTransaction.getVolume() + transaction.getVolume());
        } else if (foundTransaction.getType() == TransactionType.SALE && transaction.getType() == TransactionType.PURCHASE) {
            currentBalance = currentBalance + foundTransaction.getVolume() + transaction.getVolume();
        } else if (foundTransaction.getType() == TransactionType.SALE && transaction.getType() == TransactionType.SALE) {
            currentBalance = currentBalance - (transaction.getVolume() - foundTransaction.getVolume());
        }
        if (currentBalance < 0) {
            throw new ShortSellingNotAllowedException("Updating of current transaction failed/ Short-selling is not allowed");
        }
        transaction.setShare(share);
        transaction.setEmployee(employee);
        return transactionRepository.save(transaction);
    }

    public Transaction findTransactionById(Long id) {
        return transactionRepository.findTransactionById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction with id: " + id + " does not exist"));
    }

    public void deleteTransaction(Long transactionId) {
        Transaction foundTransaction = findTransactionById(transactionId);
        if (foundTransaction.getType() == TransactionType.PURCHASE) {
            long currentBalance = shareBalance(foundTransaction.getShare().getId()) - foundTransaction.getVolume();
            if (currentBalance < 0) {
                throw new ShortSellingNotAllowedException("Deleting the current transaction will result in Short-selling");
            }
        }
        transactionRepository.deleteById(transactionId);
    }

}

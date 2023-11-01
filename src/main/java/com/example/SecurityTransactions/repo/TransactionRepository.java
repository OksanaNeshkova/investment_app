package com.example.SecurityTransactions.repo;

import com.example.SecurityTransactions.entity.Share;
import com.example.SecurityTransactions.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findTransactionById(Long id);
}

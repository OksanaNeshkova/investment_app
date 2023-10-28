package com.example.SecurityTransactions.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "transaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @JsonBackReference("share")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")

    private Share share;

    @Column(name = "trading_volume", nullable = false)
    private long volume;

    @Column(name = "purchase_price", nullable = false)
    private float price;

    @Column(name = "fx", nullable = false)
    private float fx;
    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "trade_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final Date date = new Date();

    @JsonBackReference("employee")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")

    private Employee employee;


}


package com.example.SecurityTransactions.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="transaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    private Share share;

    @Column(name="trading_volume", nullable = false)
    private long volume;

    @Column(name="purchase_price", nullable = false)
    private float price;

    @Column(name="fx", nullable = false)
    private float fx;
    @Column(name="currency", nullable = false)
    private String currency;

    @Column(name="trade_date")
    private final Date date = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Transaction(TransactionType type, Share share, long volume, float price, float fx, String currency, Employee employee) {
        this.type = type;
        this.share = share;
        this.volume = volume;
        this.price = price;
        this.fx = fx;
        this.currency = currency;
        this.employee = employee;
    }
}


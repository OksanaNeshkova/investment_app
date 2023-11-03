package com.example.SecurityTransactions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ShareBalance {

    private String isin;

    private String shareName;

    private long balance;
}

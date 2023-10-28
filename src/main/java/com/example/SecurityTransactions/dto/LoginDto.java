package com.example.SecurityTransactions.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long personalCode;
    private String address;
    private String phone;
}

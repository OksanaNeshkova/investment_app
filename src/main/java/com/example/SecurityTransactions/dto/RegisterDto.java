package com.example.SecurityTransactions.dto;

import com.example.SecurityTransactions.entity.Role;
import lombok.Data;

@Data
public class RegisterDto {

    private String firstName;

    private String lastName;
    private String email;
    private String password;
    private long personalCode;
    private String address;
    private String phone;
    private Role role;


}

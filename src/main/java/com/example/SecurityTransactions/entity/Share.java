package com.example.SecurityTransactions.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="company_name",nullable = false)
    private String companyName;

    @Column(name="share_name",nullable = false)
    private String shareName;
    @Column(name="ISIN", nullable = false)
    private String isin;
    @Column(name="country", nullable = false)
    private String country;
    @Column(name="economic_field", nullable = false)
    private String economicField;

    @JsonManagedReference("share")
    @OneToMany(mappedBy = "share", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> stockTransactions = new ArrayList<>();
    public Share(String companyName, String shareName, String isin, String country, String economicField) {
        this.companyName = companyName;
        this.shareName = shareName;
        this.isin = isin;
        this.country = country;
        this.economicField = economicField;
    }
}

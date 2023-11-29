package com.example.jweb_final_test.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transaction_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transation_id;
    private long amount;
    private String transaction_note;
    private String account_receive;
    private String account_transfer;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}

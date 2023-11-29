package com.example.jweb_final_test.dao;

import com.example.jweb_final_test.entity.Account;
import com.example.jweb_final_test.entity.TransactionHistory;

import java.util.List;

public interface AccountDAO {
    void saveAccount(Account account);

    void saveTransaction(TransactionHistory transactionHistory);

    boolean login(String username, String password);

    Account getAccount(String username);

    List<Account> getAccountToTransfer(String username);

//    void transfer(String account, String accountTransfer, Long amount, String note);
}

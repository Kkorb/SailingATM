package com.sailpoint.atm.service;

import com.sailpoint.atm.domain.Account;

public interface TransactionService {
    String getBalance(Account account);

    void deposit(Account account, String amount);

    void withdraw(Account account, String amount);
}

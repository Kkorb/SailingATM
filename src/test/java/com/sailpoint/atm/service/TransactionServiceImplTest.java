package com.sailpoint.atm.service;

import com.sailpoint.atm.domain.Account;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionServiceImplTest {
    TransactionServiceImpl ts = TransactionServiceImpl.getInstance();
    Account account;

    @BeforeEach
    void init() {
        account = new Account("Test1 Test2", "test1", "1234", Money.parse("USD 50.50"));
    }

    @Test
    void getBalance() {
        assertEquals(ts.getBalance(account), "USD50.50");
    }

    @Test
    void getBalanceFromNullAccount() {
        assertEquals(ts.getBalance(null), "");
    }

    @Test
    void depositSuccessful() {
        ts.deposit(account, "50");
        assertEquals(ts.getBalance(account), "USD100.50");
    }

    @Test
    void depositFailure() {
        ts.deposit(account, "test");
        assertEquals(ts.getBalance(account), "USD50.50");
    }

    @Test
    void withdrawSuccessful() {
        ts.withdraw(account, "50");
        assertEquals(ts.getBalance(account), "USD0.50");
    }

    @Test
    void withdrawFailure() {
        ts.withdraw(account, "test");
        assertEquals(ts.getBalance(account), "USD50.50");
    }
}

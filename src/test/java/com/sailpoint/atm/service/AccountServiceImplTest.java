package com.sailpoint.atm.service;

import com.sailpoint.atm.domain.Account;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AccountServiceImplTest {
    AccountServiceImpl as = AccountServiceImpl.getInstance();
    Account account;
    final String testName = "test1 test2";
    final String testUsername = "test1";
    final String testPin = "1234";
    final Money testMoney = Money.parse("USD 0");

    @BeforeEach
    void init() throws NoSuchFieldException, IllegalAccessException {
        account = new Account(testName, testUsername, testPin, testMoney);

        Field instance = AccountServiceImpl.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    void createAccountSuccessful() {
        Account testAccount = as.createAccount(testName, testUsername, testPin);
        assertEquals(testAccount.getFullName(), testName);
        assertEquals(testAccount.getUsername(), testUsername);
        assertEquals(testAccount.getPin(), testPin);
        assertEquals(testAccount.getBalance(), testMoney);
    }

    @Test
    void createDuplicateAccount() {
        as.createAccount(testName, testUsername, testPin);
        Account failedTestAccount = as.createAccount(testName, testUsername, testPin);
        assertNull(failedTestAccount);
    }

    @Test
    void createAccountBadPin() {
        assertNull(as.createAccount(testName, testUsername, null));
        assertNull(as.createAccount(testName, testUsername, "123"));
        assertNull(as.createAccount(testName, testUsername, "123a"));
    }

    @Test
    void loginAccountSuccessful() {
        as.createAccount(testName, testUsername, testPin);
        Account testAccount = as.loginAccount(testUsername, testPin);
        assertEquals(testAccount.getFullName(), testName);
        assertEquals(testAccount.getUsername(), testUsername);
        assertEquals(testAccount.getPin(), testPin);
        assertEquals(testAccount.getBalance(), testMoney);
    }

    @Test
    void loginAccountFailure() {
        assertNull(as.loginAccount(testUsername, testPin));
    }

    @Test
    void loginAccountBadPin() {
        as.createAccount(testName, testUsername, testPin);
        assertNull(as.loginAccount(testUsername, ""));
    }
}

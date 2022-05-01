package com.sailpoint.atm.service;

import com.sailpoint.atm.domain.Account;
import org.javamoney.moneta.Money;

import java.util.HashMap;
import java.util.Map;

public class AccountServiceImpl implements AccountService {
    private static AccountServiceImpl instance = null;
    private final Map<String, Account> accounts = new HashMap<>();

    private AccountServiceImpl() {
    }

    public static AccountServiceImpl getInstance() {
        if (instance == null) {
            instance = new AccountServiceImpl();
        }
        return instance;
    }

    public Account createAccount(String fullName, String username, String pin) {
        if (accounts.containsKey(username)) {
            System.out.print("Failed to create account, please try again: ");
            return null;
        }
        if (pin == null || pin.length() != 4 || !pin.chars().allMatch(Character::isDigit)) {
            System.out.print("Pin must consist of 4 digits, please try again: ");
            return null;
        }
        Account account = new Account(fullName, username, pin, Money.parse("USD 0"));
        accounts.put(username, account);
        return account;
    }

    public Account loginAccount(String username, String pin) {
        Account account = accounts.get(username);
        if (account == null || !account.getPin().equals(pin)) {
            System.out.printf("Invalid %s, please try again.%n", account == null ? "username" : "pin");
            return null;
        }
        return account;
    }
}

package com.sailpoint.atm.domain;

import org.javamoney.moneta.Money;

public class Account {

    private Integer id;
    private final String fullName;
    private final String username;
    private final String pin;
    private Money balance;

    public Account(String fullName, String username, String pin, Money balance) {
        this.fullName = fullName;
        this.username = username;
        this.pin = pin;
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPin() {
        return pin;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }
}

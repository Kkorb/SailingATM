package com.sailpoint.atm.service;

import com.sailpoint.atm.domain.Account;
import org.javamoney.moneta.Money;

import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.util.Locale;

public class TransactionServiceImpl implements TransactionService {
    private static TransactionServiceImpl instance = null;
    public static final String CURRENCY = "USD ";
    public static final MonetaryAmountFormat CURRENCY_FORMATTER = MonetaryFormats.getAmountFormat(Locale.US);

    private TransactionServiceImpl() {
    }

    public static TransactionServiceImpl getInstance() {
        if (instance == null) {
            instance = new TransactionServiceImpl();
        }
        return instance;
    }

    public String getBalance(Account account) {
        return account == null ? "" : CURRENCY_FORMATTER.format(account.getBalance());
    }

    public void deposit(Account account, String amount) {
        try {
            account.setBalance(account.getBalance().add(Money.parse(CURRENCY + amount)));
            System.out.println("Successfully deposited: " + amount);
        } catch (Exception e) {
            System.out.println("Failed to deposit due to: " + e.getMessage());
        }
    }

    public void withdraw(Account account, String amount) {
        try {
            account.setBalance(account.getBalance().subtract(Money.parse(CURRENCY + amount)));
            System.out.println("Successfully withdrew: " + amount);
        } catch (Exception e) {
            System.out.println("Failed to withdraw due to: " + e.getMessage());
        }
    }
}

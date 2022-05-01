package com.sailpoint.atm.menu;

import com.sailpoint.atm.domain.Account;
import com.sailpoint.atm.service.AccountService;
import com.sailpoint.atm.service.AccountServiceImpl;

import java.util.Scanner;

public class AccountMenu {
    private static final AccountService ac = AccountServiceImpl.getInstance();

    public static Account create() {
        Scanner input = new Scanner(System.in);
        Account account = null;

        while (account == null) {
            System.out.println("Account Creator");
            System.out.println("-------------------------");
            System.out.print("Full Name: ");
            String fullName = input.nextLine();
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Pin: ");
            String pin = input.nextLine();

            account = ac.createAccount(fullName, username, pin);
        }
        System.out.println("Account creation success!");
        return account;
    }

    public static Account login() {
        Scanner input = new Scanner(System.in);
        Account account = null;

        while (account == null) {
            System.out.println("Please login:");
            System.out.println("-------------------------");
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Pin: ");
            String pin = input.nextLine();

            account = ac.loginAccount(username, pin);
        }
        System.out.println("Log in success!");
        return account;
    }
}

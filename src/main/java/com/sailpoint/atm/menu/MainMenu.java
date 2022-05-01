package com.sailpoint.atm.menu;

import com.sailpoint.atm.domain.Account;

import java.util.Scanner;

public class MainMenu {
    public static void mainMenu() {
        String selection;
        Account currentAccount = null;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose one of the following:");
            System.out.println("-------------------------");
            System.out.println("1 - Create Account");
            System.out.println("2 - Login");
            System.out.println("3 - Quit");
            System.out.println("Selection: ");

            selection = input.nextLine();
            switch (selection) {
                case "1":
                    currentAccount = AccountMenu.create();
                    break;
                case "2":
                    currentAccount = AccountMenu.login();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
            if (currentAccount != null) {
                TransactionMenu.transactionMenu(currentAccount);
                currentAccount = null;
            }
        }
    }
}

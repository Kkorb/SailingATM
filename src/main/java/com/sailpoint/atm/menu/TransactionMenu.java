package com.sailpoint.atm.menu;

import com.sailpoint.atm.domain.Account;
import com.sailpoint.atm.service.TransactionService;
import com.sailpoint.atm.service.TransactionServiceImpl;

import java.util.Scanner;

public class TransactionMenu {
    public static void transactionMenu(Account currentAccount) {
        String selection;
        TransactionService ts = TransactionServiceImpl.getInstance();
        Scanner input = new Scanner(System.in);

        System.out.printf("Hello %s please choose one of the following choices%n", currentAccount.getFullName());
        System.out.println("-------------------------");
        System.out.println("1 - Check balance");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");
        System.out.println("4 - Log Out");

        while (true) {
            System.out.println("Selection: ");
            selection = input.nextLine();
            switch (selection) {
                case "1":
                    System.out.println("Your current balance is: " + ts.getBalance(currentAccount));
                    break;
                case "2":
                    System.out.println("Please enter how much you would like the deposit: ");
                    String depositAmount = input.nextLine();
                    ts.deposit(currentAccount, depositAmount);
                    break;
                case "3":
                    System.out.println("Please enter how much you would like the withdraw: ");
                    String withdrawAmount = input.nextLine();
                    ts.withdraw(currentAccount, withdrawAmount);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }
}

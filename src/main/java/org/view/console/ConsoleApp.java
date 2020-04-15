package org.view.console;

import org.controller.BankAccountController;
import org.controller.ControllerManager;
import org.controller.OwnerController;
import org.model.Account;
import org.model.Transaction;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private BankAccountController bankAccountController;
    private OwnerController ownerController;

    public static void main(String[] args) {
        new ConsoleApp().run();
    }

    public ConsoleApp() {
        ControllerManager controllerManager = new ControllerManager();
        bankAccountController = controllerManager.getAccountController();
        ownerController = controllerManager.getOwnerController();
    }

    public void run() {
        String ownerName = "jperez";

        // TODO Change this to use DTOs
        List<Account> accounts = ownerController.getAccountsByOwner(ownerName);

        // TODO Add InfoProvider to replace this logic
        Account account = accounts.get(0);

        printWelcomeMessage(ownerName, account.getId());
        showMainMenu();
        selectOption(account.getId());
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private void printWelcomeMessage(String name, int accountId) {
        // Welcome to the BankApp
        print("Welcome " + name);
        print("Your current account is " + accountId);
    }

    private void showMainMenu() {
        // Main Menu
        print(System.lineSeparator());
        print("********************");
        print("(W) Withdraw");
        print("(D) Deposit");
        print("(B) My Balance");
        print("(T) My Transactions");
        print("(E) Exit");
        print("********************");
    }

    private void selectOption(int accountId) {
        // Press a key to select an option
        try (Scanner scanner = new Scanner(System.in)){
            boolean closeApp = false;
            char option;
            while (true) {
                System.out.print("Select an option: ");
                option = getSelectedOption(scanner);
                switch (option) {
                    case 'A':
                        showMainMenu();
                        break;
                    case 'E':
                        print("Exit...");
                        closeApp = true;
                        break;
                    case 'B':
                        balance(accountId);
                        break;
                    case 'W':
                        withdraw(scanner, accountId);
                        break;
                    case 'D':
                         deposit(scanner,accountId);
                         break;
                    case 'T':
                        transactions(accountId);
                        break;
                    default:
                        print(option + " is an invalid option");
                        break;
                }

                // Is running
                if (closeApp) {
                    break;
                }

                print("(A) Show All options");
            }
        }
    }

    private char getSelectedOption(Scanner scanner) {
        return scanner.next().trim().toUpperCase().charAt(0);
    }

    private void withdraw(Scanner scanner, int accountId) {
        print("Enter amount you need to withdraw: ");
        double amount = scanner.nextDouble();
        bankAccountController.withdraw(accountId, amount);
    }
    private void deposit(Scanner scanner, int accountId) {
        print("Enter amount you need to deposit: ");
        double amount = scanner.nextDouble();
        bankAccountController.deposit(accountId, amount);

    }
    private void balance(int accountId) {
        double balance = bankAccountController.getBalance(accountId);
        print("My Balance is: "+ balance);
    }
    private void transactions(int accountId) {
        List<Transaction> transactions = bankAccountController.getTransactions(accountId);
        for (Transaction transaction : transactions) {
            print("Id: " + transaction.getId());
            print("Transaction Type: " + transaction.getType());
            print("Amount: " + transaction.getAmount());
            print("Date Time: " + transaction.getDateTime());
            print(System.lineSeparator());
        }
    }
}

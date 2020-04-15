package org.controller;

import org.controller.interfaces.IAccountOperator;
import org.controller.providers.AccountBalanceProvider;
import org.controller.providers.AccountTransactionsProvider;
import org.model.Transaction;

import java.util.List;

public class BankAccountController {
    private IAccountOperator withdrawOperator;
    private IAccountOperator depositOperator;
    private AccountBalanceProvider balance;
    private AccountTransactionsProvider transactions;

    public BankAccountController(IAccountOperator withdrawOperator, IAccountOperator depositOperator, AccountBalanceProvider balance, AccountTransactionsProvider transactions) {
        this.withdrawOperator = withdrawOperator;
        this.depositOperator = depositOperator;
        this.balance = balance;
        this.transactions = transactions;
    }
    public Double getBalance(Integer accountId){
        return balance.get(accountId);
    }
    public void withdraw(int accountId, double amount) {
        double balance = getBalance(accountId);
        if(amount > 0 && amount<=balance){
           this.withdrawOperator.execute(accountId, amount);
        }
        else if (amount<=0)
            System.out.println("Invalid amount");
        else {
            System.out.println("Insufficient funds in the account");
        }

    }
    public void deposit(int accountId, double amount) {
        if(amount>0) {
           this.depositOperator.execute(accountId, amount);
        }
        else{
            System.out.println("Invalid amount");
        }
    }

    public List<Transaction> getTransactions(int accountId){
        return transactions.get(accountId);
    }


}

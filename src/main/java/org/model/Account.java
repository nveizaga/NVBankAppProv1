package org.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String ownerId;
    private double balance;
    private List<Transaction> transactions;

    public Account(int id, String ownerId,double balance) {
        this.id = id;
        this.ownerId = ownerId;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public Double getBalance() {
        return balance;
    }
    public List<Transaction> getTransactions(){
        return transactions;
    }
    public void updateBalance(Transaction transaction){
        if(transaction.getType()==TransactionType.WITHDRAW){
            this.balance=balance-transaction.getAmount();
        }
        else{
            this.balance=balance+transaction.getAmount();
        }
    }
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        updateBalance(transaction);
    }

}

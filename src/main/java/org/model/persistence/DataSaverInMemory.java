package org.model.persistence;

import org.model.Account;
import org.model.Owner;
import org.model.Transaction;
import org.model.interfaces.IDataSaver;

import java.util.List;

public class DataSaverInMemory implements IDataSaver {
    @Override
    public Owner getOwnerById(String id) {
        return DataInMemory.getInstance().getOwnerById(id).get();
    }

    @Override
    public void addOwner(Owner owner) {
        DataInMemory.getInstance().addOwner(owner);
    }

    @Override
    public Account getAccountById(int id) {
        return DataInMemory.getInstance().getAccountById(id).get();
    }

    @Override
    public List<Account> getAccountsByOwner(String owner) {
        return getOwnerById(owner).getAccounts();
    }

    @Override
    public void addAccount(Account account) {
        DataInMemory.getInstance().addAccount(account);
    }

    @Override
    public Transaction getTransactionByAccountId(int accountId) {
        return DataInMemory.getInstance().getTransactionByAccountId(accountId).get();
    }

    @Override
    public void addTransaction(Transaction transaction) {
        DataInMemory.getInstance().addTransaction(transaction);
    }

    @Override
    public Double getBalanceByAccountId(int accountId) {
        return DataInMemory.getInstance().getBalanceByAccountId(accountId);
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(int accountId){
        return DataInMemory.getInstance().getTransactionsByAccountId(accountId);
    }

    @Override
    public void updateBalanceByAccountId(Transaction transaction){
        DataInMemory.getInstance().updateBalanceByAccountId(transaction);
    }

}

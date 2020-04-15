package org.model.interfaces;

import org.model.Account;
import org.model.Owner;
import org.model.Transaction;

import java.util.List;

public interface IDataSaver {
    Owner getOwnerById(String id);

    void addOwner(Owner owner);

    Account getAccountById(int id);

    List<Account> getAccountsByOwner(String owner);

    void addAccount(Account account);

    Transaction getTransactionByAccountId(int accountId);

    void addTransaction(Transaction transaction);

    Double getBalanceByAccountId(int accountId);

    List<Transaction> getTransactionsByAccountId(int accountId);

    void updateBalanceByAccountId(Transaction transaction);

}

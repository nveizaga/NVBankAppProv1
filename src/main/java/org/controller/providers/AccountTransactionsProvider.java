package org.controller.providers;


import org.controller.interfaces.IInfoProvider;
import org.model.Account;
import org.model.Transaction;
import org.model.interfaces.IDataSaver;

import java.util.List;

public class AccountTransactionsProvider implements IInfoProvider<List<Transaction>, Integer> {

    private IDataSaver dataSaver;

    public AccountTransactionsProvider(IDataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    @Override
    public List<Transaction> get(Integer accountId) {
        return dataSaver.getTransactionsByAccountId(accountId);
    }
}
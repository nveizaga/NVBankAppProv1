package org.controller.providers;

import org.controller.interfaces.IInfoProvider;
import org.model.Account;
import org.model.interfaces.IDataSaver;

import java.util.List;

public class AccountsByOwnerProvider implements IInfoProvider<List<Account>, String> {

    private IDataSaver dataSaver;

    public AccountsByOwnerProvider(IDataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    @Override
    public List<Account> get(String owner) {
        return dataSaver.getAccountsByOwner(owner);
    }
}

package org.controller;

import org.controller.interfaces.IInfoProvider;
import org.model.Account;

import java.util.List;

public class OwnerController {

    private IInfoProvider<List<Account>, String> accountsProvider;

    public OwnerController(IInfoProvider<List<Account>, String> accountsProvider) {
        this.accountsProvider = accountsProvider;
    }

    public List<Account> getAccountsByOwner(String owner) {
        return accountsProvider.get(owner);
    }
}

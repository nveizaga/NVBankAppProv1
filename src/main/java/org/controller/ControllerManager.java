package org.controller;

import org.controller.operators.DepositOperator;
import org.controller.operators.WithdrawOperator;
import org.controller.providers.AccountBalanceProvider;
import org.controller.providers.AccountTransactionsProvider;
import org.controller.providers.AccountsByOwnerProvider;
import org.model.persistence.DataSaverInMemory;

public class ControllerManager {

    public BankAccountController getAccountController() {
        return new BankAccountController(new WithdrawOperator(new DataSaverInMemory()),new DepositOperator(new DataSaverInMemory()),new AccountBalanceProvider(new DataSaverInMemory()),new AccountTransactionsProvider(new DataSaverInMemory()));
    }

    public OwnerController getOwnerController() {
        return new OwnerController(new AccountsByOwnerProvider(new DataSaverInMemory()));
    }
}

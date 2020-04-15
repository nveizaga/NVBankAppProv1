package org.controller.operators;

import org.controller.interfaces.IAccountOperator;
import org.model.Transaction;
import org.model.TransactionType;
import org.model.interfaces.IDataSaver;

public class DepositOperator implements IAccountOperator {

    private IDataSaver dataSaver;

    public DepositOperator(IDataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }
    @Override
    public boolean execute(int id, double amount) {
        Transaction deposit = new Transaction(TransactionType.DEPOSIT, amount, id);
        dataSaver.addTransaction(deposit);
        System.out.println("successful deposit operation");
        return true;
    }
}

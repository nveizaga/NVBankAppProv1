package org.controller.operators;

import org.controller.interfaces.IAccountOperator;
import org.model.Transaction;
import org.model.TransactionType;
import org.model.interfaces.IDataSaver;

public class WithdrawOperator implements IAccountOperator {

    private IDataSaver dataSaver;

    public WithdrawOperator(IDataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }
    @Override
    public boolean execute(int id, double amount) {
        Transaction withdraw = new Transaction(TransactionType.WITHDRAW, amount, id);
        dataSaver.addTransaction(withdraw);
        System.out.println("successful withdraw operation");
        return true;
    }
}

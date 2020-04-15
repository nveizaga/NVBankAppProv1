package org.controller.providers;


        import org.controller.interfaces.IInfoProvider;
        import org.model.Account;
        import org.model.interfaces.IDataSaver;

        import java.util.List;

public class AccountBalanceProvider implements IInfoProvider<Double, Integer> {

    private IDataSaver dataSaver;

    public AccountBalanceProvider(IDataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    @Override
    public Double get(Integer accountId) {
        return dataSaver.getBalanceByAccountId(accountId);
    }
}
package solid.principles;

import java.util.List;

public class LiskovsSubstitutionP {
    public static void main(String[] args) {

        Client client = new Client(
                List.of(new SavingsAccount()),
                List.of(new FixedDepositAccount(), new SavingsAccount())
        );

        client.processWithdrawals();
        client.processDeposits();
    }
}

abstract class WithdrawableAccounts extends NonWithdrawableAccounts{
    abstract void withdraw(int amount);
}

abstract class NonWithdrawableAccounts{
    abstract void deposit(int amount);
}

class FixedDepositAccount extends NonWithdrawableAccounts
{
    @Override
    void deposit(int amount) {
        System.out.println("deposting amount: " + amount + "in FD ");
    }
}

class SavingsAccount extends WithdrawableAccounts
{
    @Override
    void deposit(int amount) {
        System.out.println("deposting amount: " + amount + "in FD ");
    }

    @Override
    void withdraw(int amount) {
        System.out.println("withdrawing amount: " + amount + "from Saving accounts ");
    }
}

class Client
{
    List<WithdrawableAccounts> withdrawableAccounts;
    List<NonWithdrawableAccounts> nonWithdrawableAccounts;

    public Client(List<WithdrawableAccounts> withdrawableAccounts,
                  List<NonWithdrawableAccounts> nonWithdrawableAccounts) {
        this.withdrawableAccounts = withdrawableAccounts;
        this.nonWithdrawableAccounts = nonWithdrawableAccounts;
    }

    void processWithdrawals() {
        for (WithdrawableAccounts account : withdrawableAccounts) {
            account.withdraw(500);
        }
    }

    void processDeposits() {
        for (NonWithdrawableAccounts account : nonWithdrawableAccounts) {
            account.deposit(1000);
        }
    }
}
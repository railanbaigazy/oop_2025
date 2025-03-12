package lab6.AbstractBanking;

import java.util.Date;

public class TimeDepositAccount extends Account {
    private final Date maturityDate;
    
    public TimeDepositAccount(double balance, Date maturityDate) {
        super(balance);
        this.maturityDate = maturityDate;
    }

    @Override
    public String toString() {
        return getDescription() + ": current balance is " + balance;
    }

    public String getDescription() {
        return "Time Deposit Account " + maturityDate;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    
}
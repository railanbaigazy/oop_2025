/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.AbstractBanking;

/**
 *
 * @author hans
 */
public class CheckingAccount extends Account {
    private final double overDraftLimit;

    CheckingAccount(double balance, double overDraftLimit) {
        super(balance);
        this.overDraftLimit = overDraftLimit;
    }

    CheckingAccount(double balance) {
        this(balance, 0);
    }

    @Override
    public String toString() {
        return getDescription() + ": current balance is " + balance;
    }

    public String getDescription() {
        return "Checking Account" ;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance + overDraftLimit) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    
}

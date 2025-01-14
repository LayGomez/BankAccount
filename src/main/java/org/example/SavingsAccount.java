package org.example;

public class SavingsAccount extends BankAccount{
    private boolean isActive;

    public SavingsAccount(Long balance, float annualRate) {
        super(balance, annualRate);
        this.isActive = balance >= 10000;
    }


}

package org.example;

public class CheckingAccount extends BankAccount{
    private float bankOverdraft;

    public CheckingAccount(Long balance, float annualRate) {
        super(balance, annualRate);
        this.bankOverdraft = 0;

    }
}

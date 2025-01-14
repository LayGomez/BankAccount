package org.example;

abstract class BankAccount {

    protected Long balance;

    protected int numConsignment;

    protected int numWithdraw;

    protected float annualRate;

    protected  float monthlyCommission;

    public BankAccount(Long balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
        this.numConsignment = 0;
        this.numWithdraw = 0;
        this.monthlyCommission = 0;
    }


}

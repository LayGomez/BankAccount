package org.example;

public class BankAccount {

    protected float balance;

    protected int numConsignment;

    protected int numWithdraw;

    protected float annualRate;

    protected  float monthlyCommission;

    public BankAccount(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
        this.numConsignment = 0;
        this.numWithdraw = 0;
        this.monthlyCommission = 0;
    }

    public float getBalance() {
        return balance;
    }

    public int getNumConsignment() {
        return numConsignment;
    }

    public int getNumWithdraw() {
        return numWithdraw;
    }

    public float getAnnualRate() {
        return annualRate;
    }

    public float getMonthlyCommission() {
        return monthlyCommission;
    }

    public void consignMoney(float amount){
        if (amount > 0) {
            balance += amount;
            numConsignment ++;
        }
    }

    public void withdrawMoney(float amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            numWithdraw ++;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void calculateMonthlyInterest(){
        float monthlyInterest = balance * (annualRate / 12) / 100;
        balance += monthlyInterest;
    }

    public void monthlyStatement() {
        balance -= monthlyCommission;
        calculateMonthlyInterest();
    }

    public void print(){
        System.out.println("Saldo: " + balance);
        System.out.println("Number of consignments:" + numConsignment);
        System.out.println("Number of withdrawals: " + numWithdraw);
        System.out.println("Annual Rate: " + annualRate);
        System.out.println("Monthly Commission: " + monthlyCommission);
    }


}

package org.example;

public class CheckingAccount extends BankAccount{
    private float bankOverdraft;

    public CheckingAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.bankOverdraft = 0;
    }

    public float getBankOverdraft() {
        return bankOverdraft;
    }

    @Override
    public void withdrawMoney(float amount){
        if (amount > 0) {
            if (amount <= balance){
                super.withdrawMoney(amount);
            } else {
                bankOverdraft += (amount - balance);
                balance = 0;
                numWithdraw ++;
            }
        } else {
            System.out.println("Invalid Amount");
        }

    }

    @Override
    public void consignMoney(float amount) {
        if (bankOverdraft > 0){
            if (amount >= bankOverdraft){
                balance += (amount - bankOverdraft);
                bankOverdraft = 0;
            } else {
                bankOverdraft -= amount;
            }
        } else {
            super.consignMoney(amount);
        }
    }

    @Override
    public void print(){
        System.out.println("Balance: " + balance);
        System.out.println("Monthly Commission: " + monthlyCommission);
        System.out.println("Number of transactions: " + (numWithdraw + numConsignment));
        System.out.println("Bank Overdraft" + bankOverdraft);
    }
}

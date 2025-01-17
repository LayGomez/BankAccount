package org.example;

public class SavingsAccount extends BankAccount{
    private boolean isActive;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.isActive = balance >= 10000;
    }

    @Override
    public void consignMoney(float amount){
        if(isActive){
            super.consignMoney(amount);
        } else {
            System.out.println("The account is inactive. Consignments cannot be made.");
        }
        checkStatus();
    }

    @Override
    public void withdrawMoney(float amount){
        if (isActive){
            super.withdrawMoney(amount);
        } else {
            System.out.println("The account is inactive. Withdrawals cannot be made.");
        }
        checkStatus();
    }

    @Override
    public void calculateMonthlyInterest() {
        if (numWithdraw > 4){
            monthlyCommission += (numWithdraw - 4) * 1000;
        }
        super.calculateMonthlyInterest();
        checkStatus();
    }

    public void print(){
        System.out.println("Balance: " + balance);
        System.out.println("Monthly Commission: " + monthlyCommission);
        System.out.println("Number of transactions: " + (numConsignment + numWithdraw));
    }

    public void checkStatus(){
        isActive = balance >= 10000;
    }
}

package org.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BankAccountTest {
    @Test
    void testConsignmentMoney(){
        BankAccount bankAccount = new BankAccount(10000, 4);
        bankAccount.consignMoney(5000);

        float expected = 15000;
        assertThat(bankAccount.balance, is(equalTo(expected)));
    }

    @Test
    void testWithdrawMoney(){
        BankAccount bankAccount = new BankAccount(10000, 5);
        bankAccount.withdrawMoney(5000);

        float expected = 5000;

        assertThat(bankAccount.balance, is(equalTo(expected)));
    }

    @Test
    void testCalculateMonthlyStatement(){
        BankAccount bankAccount = new BankAccount(10000, 5);
        bankAccount.calculateMonthlyInterest();

        float expected = 10000 + (10000 * (5.0f / 12) / 100);

        assertThat(bankAccount.balance, is(equalTo(expected)));
    }

    @Test
    void testMonthlyStatement(){
        BankAccount bankAccount = new BankAccount(15000, 5);
        bankAccount.monthlyStatement();

        float expected = 15000 + (15000 * (5.0f / 12) / 100);;

        assertThat(bankAccount.balance, is(equalTo(expected)));
    }


}
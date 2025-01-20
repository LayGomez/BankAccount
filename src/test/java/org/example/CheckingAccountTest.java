package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class CheckingAccountTest {

        @Test
        void testOverdraftWhenWithdrawExceedsBalance() {
            CheckingAccount checkingAccount = new CheckingAccount(10000, 3);

            checkingAccount.withdrawMoney(15000);

            assertThat(checkingAccount.getBalance(), is(equalTo(0f)));
            assertThat(checkingAccount.getBankOverdraft(), is(equalTo(5000f)));
        }

        @Test
        void testReduceOverdraftWithConsignMoney() {
            CheckingAccount checkingAccount = new CheckingAccount(10000, 3);

            checkingAccount.withdrawMoney(15000); // Sobregiro de 5000
            checkingAccount.consignMoney(7000);   // Reduce el sobregiro

            assertThat(checkingAccount.getBalance(), is(equalTo(2000f))); // Saldo después de reducir sobregiro
            assertThat(checkingAccount.getBankOverdraft(), is(equalTo(0f)));  // Sobregiro debe ser 0
        }

        @Test
        void testMonthlyStatementWithOverdraft() {
            CheckingAccount checkingAccount = new CheckingAccount(10000, 3);

            checkingAccount.withdrawMoney(15000);
            checkingAccount.monthlyStatement();

            float expectedBalance = 0;
            assertThat(checkingAccount.getBalance(), is(equalTo(expectedBalance)));
            assertThat(checkingAccount.getBankOverdraft(), is(equalTo(5000f)));
        }
    }

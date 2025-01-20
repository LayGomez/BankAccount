package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    void testInitialAccountStatus() {
        SavingAccount activeAccount = new SavingAccount(12000, 4);
        assertTrue(activeAccount.isActive());

        SavingAccount inactiveAccount = new SavingAccount(8000, 4);
        assertFalse(inactiveAccount.isActive());
    }

    @Test
    void testConsignMoneyWhenActive() {
        SavingAccount savingAccount = new SavingAccount(12000, 4);
        savingAccount.consignMoney(5000);

        assertThat(savingAccount.getBalance(), is(equalTo(17000f)));
        assertTrue(savingAccount.isActive());
    }

    @Test
    void testConsignMoneyWhenInactive() {
        SavingAccount savingAccount = new SavingAccount(8000, 4);
        assertFalse(savingAccount.isActive());
    }

    @Test
    void testWithdrawMoneyWhenActive() {
        SavingAccount savingAccount = new SavingAccount(12000, 4);
        savingAccount.withdrawMoney(3000);

        assertThat(savingAccount.getBalance(), is(equalTo(9000f)));
        assertFalse(savingAccount.isActive());
    }

    @Test
    void testWithdrawMoneyWhenInactive() {
        SavingAccount savingAccount = new SavingAccount(9000, 4);
        savingAccount.withdrawMoney(1000);

        assertThat(savingAccount.getBalance(), is(equalTo(9000f)));
        assertFalse(savingAccount.isActive());
    }

    @Test
    void testMonthlyStatementWithExcessWithdrawals() {
        SavingAccount savingAccount = new SavingAccount(25000, 4);

        savingAccount.withdrawMoney(2000);
        savingAccount.withdrawMoney(2000);
        savingAccount.withdrawMoney(2000);
        savingAccount.withdrawMoney(2000);
        savingAccount.withdrawMoney(2000);

        assertThat(savingAccount.getBalance(), is(equalTo(15000.0f)));

        savingAccount.calculateMonthlyInterest();

        float expectedBalance = 15000 - 1000 + (14000 * (4.0f / 12) / 100);

        assertThat(savingAccount.getBalance(), is(equalTo(expectedBalance)));
    }

    @Test
    void testPrint() {
        SavingAccount savingAccount = new SavingAccount(12000, 4);
        savingAccount.consignMoney(2000);
        savingAccount.withdrawMoney(5000);

        savingAccount.print();
        assertThat(savingAccount.getBalance(), is(equalTo(9000f)));

    }

}
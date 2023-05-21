package com.contal.group.model.bank;

import com.contal.group.model.people.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTests {

    private Client client;

    @BeforeEach
    void BeforeEach(){
        client = new Client( new Account("123456", "0987"));
    }

    @DisplayName("Check the account number and password")
    @Test
    void testValidateAccountNumAndPassword(){
        //given
        //when
        //then
        assertEquals("123456",client.getAccount().getAccountNum());
        assertEquals("0987",client.getAccount().getPassword());
    }

    @DisplayName("Check the current balance")
    @Test
    void testCheckCurrentBalance(){
        //given
        //when
        client.getAccount().setBalance("123456", "0987");

        //then
        assertEquals(1000, client.getAccount().getBalance());
    }

    @DisplayName("withdraw money from account")
    @Test
    void testWithdrawMoneyFromDevice(){
        //given
        client.getAccount().setBalance(client.getAccount().getAccountNum(), client.getAccount().getPassword());

        //when
        //then
        assertEquals(990, client.getAccount().withdrawMoney(10));
    }

    @DisplayName("save money from account")
    @Test
    void testSaveMoneyFromDevice() {
        //given
        client.getAccount().setBalance(client.getAccount().getAccountNum(), client.getAccount().getPassword());

        //when
        //then
        assertEquals(1010, client.getAccount().saveMoney(10));
    }
}

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
        client = new Client( new Account("1234567", "0987",100));
    }

    @DisplayName("Check the account number and password")
    @Test
    void testValidateAccountNumAndPassword(){
        //given
        //when
        //then
        assertEquals("1234567",client.getAccount().getAccountNum());
        assertEquals("0987",client.getAccount().getPassword());
    }

    @DisplayName("Check the current balance")
    @Test
    void testCheckCurrentBalance(){
        //given
        //when
        //then
        assertEquals(100, client.getAccount().getBalance());
    }

    @DisplayName("withdraw money from account")
    @Test
    void testWithdrawMoneyFromDevice(){
        //given
        //when
        int balance = client.getAccount().withdrawMoney(10);
        //then
        assertEquals(90, balance);
    }

    @DisplayName("save money from account")
    @Test
    void testSaveMoneyFromDevice(){
        //given
        //when
        int balance = client.getAccount().saveMoney(10);
        //then
        assertEquals(110, balance);
    }
}

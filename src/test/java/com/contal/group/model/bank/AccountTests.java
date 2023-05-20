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
        client = new Client("1234567", "0987", new Account(100));
    }

    @DisplayName("Check the account number and password")
    @Test
    void validateAccountNumAndPassword(){
        //given
        //when
        //then
        assertEquals("1234567",client.getAccountNum());
        assertEquals("0987",client.getPass());
    }

    @DisplayName("Check the current balance")
    @Test
    void checkCurrentBalance(){
        //given
        //when
        //then
        assertEquals(100, client.getAccount().getBalance());
    }

    @DisplayName("withdraw money from account")
    @Test
    void withdrawMoneyFromDevice(){
        //given
        //when
        int balance = client.getAccount().withdrawMoney(10);
        //then
        assertEquals(90, balance);
    }

    @DisplayName("save money from account")
    @Test
    void saveMoneyFromDevice(){
        //given
        //when
        int balance = client.getAccount().saveMoney(10);
        //then
        assertEquals(110, balance);
    }
}

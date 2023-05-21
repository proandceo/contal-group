package com.contal.group.model.people;

import com.contal.group.model.bank.Account;
import com.contal.group.service.device.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClientTest {
    Device device;
    String type;

    @BeforeEach
    void BeforeEach(){
        device = new Device(new Client(
                new Account("1234567", "0987", 1000)));
        type = device.getType();
    }

    @DisplayName("Check the validation of client")
    @Test
    void testCheckClient(){
        //given
        Client client = device.getClient();
        // when
        String accountNum = client.getAccount().getAccountNum();
        String password = client.getAccount().getPassword();

        //then
        assertEquals("1234567", accountNum);
        assertEquals("0987", password);
    }

    @DisplayName("Check who use this device")
    @Test
    void testCheckTheUser(){
        //given
        //when
        //then
        assertEquals("client", type);
    }

    @DisplayName("Check how much money is left")
    @Test
    void testCheckBalance(){
        //given
        Client client = device.getClient();
        //when
        //then
        assertEquals(1000,client.getAccount().getBalance());
    }

}

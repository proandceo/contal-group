package com.contal.group.model.people;

import com.contal.group.model.bank.Account;
import com.contal.group.service.device.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClientTest {
    DeviceService deviceService;
    String type;

    @BeforeEach
    void BeforeEach(){
        deviceService = new DeviceService(new Client(
                new Account("123456", "0987")));
        type = deviceService.getType();
    }

    @DisplayName("Check the validation of client")
    @Test
    void testCheckClient(){
        //given
        Client client = deviceService.getClient();
        // when
        String accountNum = client.getAccount().getAccountNum();
        String password = client.getAccount().getPassword();

        //then
        assertEquals("123456", accountNum);
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
        Client client = deviceService.getClient();
        //when
        client.getAccount().setBalance(client.getAccount().getAccountNum(), client.getAccount().getPassword());
        //then
        assertEquals(1000,client.getAccount().getBalance());
    }

}

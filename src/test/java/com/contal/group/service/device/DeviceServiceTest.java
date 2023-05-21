package com.contal.group.service.device;

import com.contal.group.model.bank.Account;
import com.contal.group.model.people.Admin;
import com.contal.group.model.people.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeviceServiceTest {

    DeviceService deviceServiceAdmin;
    DeviceService deviceServiceClient;
    Client client;

    @BeforeEach
    void BeforeEach(){
        deviceServiceAdmin = new DeviceService(new Admin("1234111", "0987"));
        client = new Client(new Account("234567", "0000"));
        deviceServiceClient = new DeviceService(client);
    }

    @DisplayName("Add money in the device")
    @Test
    void testAddMoney(){
        //given
        //when
        String type = deviceServiceAdmin.getType();
        deviceServiceAdmin.addNote(type, "50", 10);

        //then
        assertEquals("50 Notes left 110||20 Notes left 100",
                deviceServiceAdmin.checkHowMuchMoneyHasIn());
    }

//    @DisplayName("withdraw money")
//    @Test
//    void testWithdrawMoney(){
//        //given
//        //when
//        String type = deviceServiceClient.getType();
//
//        //then
//        assertEquals(1900, deviceServiceClient.withdrawMoney(client, 100));
//    }
}

package com.contal.group.model.people;

import com.contal.group.service.device.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminTest {
    DeviceService deviceService;
    String type;

    @BeforeEach
    void BeforeEach(){
        deviceService = new DeviceService(new Admin("RexPark", "contal"));
        type = deviceService.getType();
    }

    @DisplayName("Check the validation of manager")
    @Test
    void testCheckManager(){
        //given
        Admin admin = new Admin("RexPark", "contal");
        // when
        String id = admin.getId();
        String pass = admin.getPass();

        //then
        assertEquals("RexPark", id);
        assertEquals("contal", pass);
    }

    @DisplayName("Check who use this device")
    @Test
    void testCheckTheUser(){
        //given
        //when
        //then
        assertEquals("manager", type);
    }

    @DisplayName("Check how much money is left")
    @Test
    void testCheckMoney(){
        //given
        //when
        //then
        if ("manager".equals(type)){
            assertEquals("50 Notes left 100||20 Notes left 100",
                    deviceService.checkHowMuchMoneyHasIn());
        }
    }
}

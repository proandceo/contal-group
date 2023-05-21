package com.contal.group.model.people;

import com.contal.group.service.device.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AdminTest {
    Device device;
    String type;

    @BeforeEach
    void BeforeEach(){
        device = new Device(new Admin("RexPark", "contal"));
        type = device.getType();
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
            assertEquals("50 Notes left 30||20 Notes left 30",
                    device.checkHowMuchMoneyHasIn());
        }
    }
}

package com.contal.group.model.people;

import com.contal.group.model.device.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PeopleTest {
    Device device;
    String type;

    @BeforeEach
    void BeforeEach(){
        device = new Device();
        type = device.getType(new Manager("RexPark", "contal"));
    }

    @DisplayName("Check the validation of manager")
    @Test
    void testCheckManager(){
        //given
        Manager admin = new Manager("RexPark", "contal");
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

    @DisplayName("Add money in the device")
    @Test
    void testAddMoney(){
        //given
        //when
        device.addNote("50", 10);

        //then
        assertEquals("50 Notes left 40||20 Notes left 30",
                device.checkHowMuchMoneyHasIn());
    }

    @DisplayName("Remove money in the device")
    @Test
    void testRemoveMoney(){
        //given
        //when
        device.removeNote("50", 20);
        device.removeNote("20", 10);

        //then
        assertEquals("50 Notes left 10||20 Notes left 20",
                device.checkHowMuchMoneyHasIn());
    }
}

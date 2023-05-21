package com.contal.group.service.device;

import com.contal.group.model.people.Admin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeviceTest {

    @DisplayName("Add money in the device")
    @Test
    void testAddMoney(){
        //given
        Device device = new Device(new Admin("RexPark", "contal"));
        //when
        String type = device.getType();
        device.addNote(type, "50", 10);

        //then
        assertEquals("50 Notes left 110||20 Notes left 100",
                device.checkHowMuchMoneyHasIn());
    }
}

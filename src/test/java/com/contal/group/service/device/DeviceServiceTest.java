package com.contal.group.service.device;

import com.contal.group.model.people.Admin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeviceServiceTest {

    @DisplayName("Add money in the device")
    @Test
    void testAddMoney(){
        //given
        DeviceService deviceService = new DeviceService(new Admin("1234111", "0987"));
        //when
        String type = deviceService.getType();
        deviceService.addNote(type, "50", 10);

        //then
        assertEquals("50 Notes left 110||20 Notes left 100",
                deviceService.checkHowMuchMoneyHasIn());
    }
}

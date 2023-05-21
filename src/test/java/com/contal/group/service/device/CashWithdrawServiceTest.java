package com.contal.group.service.device;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashWithdrawServiceTest {

    @DisplayName("check whether withdraw or not")
    @Test
    void testChangeNote(){
        assertEquals("Unable to withdraw", new CashWithdrawService().cashDispensing(10));
    }
}

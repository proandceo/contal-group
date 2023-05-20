package com.contal.group.model.money;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTests {

    private Notes fiftyNote;
    private Coins twoCoin;

    @BeforeEach
    void beforeEach() {
        fiftyNote = new Notes("50", 10);
        twoCoin = new Coins("2", 2);
    }

    @DisplayName("Count each Notes")
    @Test
    public void testCountNotes() {
        // given

        // when
        int amountFifty = fiftyNote.currentCount();
        int amountTwo = twoCoin.currentCount();

        // then
        assertEquals(10, amountFifty);
        assertEquals(2, amountTwo);
    }

    @DisplayName("show the value of Money")
    @Test
    public void testValueNote(){
        // given

        // when
        String valueFifty = fiftyNote.getNoteType();
        String valueTwenty = twoCoin.getNoteType();

        // then
        assertEquals("50", valueFifty);
        assertEquals("2",  valueTwenty);
    }
}

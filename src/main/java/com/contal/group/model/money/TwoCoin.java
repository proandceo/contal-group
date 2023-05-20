package com.contal.group.model.money;

public class TwoCoin extends Coins {

    private int value;

    public TwoCoin(int count){
        super(count);
        this.value = 2;
    }

    @Override
    public int getValue() {
        return value;
    }
}

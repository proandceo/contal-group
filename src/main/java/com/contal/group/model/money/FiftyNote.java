package com.contal.group.model.money;

public class FiftyNote extends Notes {

    private int value;

    public FiftyNote(int count){
        super(count);
        this.value = 50;
    }

    @Override
    public int getValue() {
        return value;
    }
}

package com.contal.group.model.money;

/**
 * concrete class for 50 note
 */
abstract class Notes implements Money {

    private int currentCount;
    public abstract int getValue();

    public Notes(int count) {
        this.currentCount = count;
    }

    @Override
    public int currentCount() {
        return currentCount;
    }

}

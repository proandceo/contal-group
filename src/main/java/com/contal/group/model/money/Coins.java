package com.contal.group.model.money;

abstract public class Coins implements Money{

    private int currentCount;
    public abstract int getValue();

    public Coins(int count) {
        this.currentCount = count;
    }

    @Override
    public int currentCount() {
        return currentCount;
    }
}

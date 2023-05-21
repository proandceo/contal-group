package com.contal.group.model.money;

public class Coins implements Money{

    private int currentCount;
    private final String value;

    public Coins(String value, int count) {
        this.value = value;
        this.currentCount = count;
    }

    @Override
    public int getCurrentCount() {
        return currentCount;
    }

    @Override
    public void setCurrentCount(int count){
        this.currentCount = count;
    }

    @Override
    public String getNoteType(){
        return value;
    }

    public void addCoin(int count){
        currentCount += count;
    }

    public void removeCoin(int count){
        currentCount -= count;
    }
}

package com.contal.group.model.money;

/**
 * control notes like $50, $20
 * also it will use $5, $10, $100 later
 */
public class Notes implements Money {

    int currentCount;
    String noteType;

    public Notes(String noteType, int count) {
        this.noteType = noteType;
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
        return noteType;
    }

    @Override
    public String toString(){
        return noteType + " Notes left " + currentCount;
    }

    public void addNote(int count){
        currentCount += count;
    }

    public void removeNote(int count){
        currentCount -= count;
    }



}

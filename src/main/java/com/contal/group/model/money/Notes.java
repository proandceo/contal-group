package com.contal.group.model.money;

/**
 * concrete class for 50 note
 */
public class Notes implements Money {

    private int currentCount;
    private final String noteType;

    public Notes(String noteType, int count) {
        this.noteType = noteType;
        this.currentCount = count;
    }

    @Override
    public int currentCount() {
        return currentCount;
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

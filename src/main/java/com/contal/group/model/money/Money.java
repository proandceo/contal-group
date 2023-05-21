package com.contal.group.model.money;

/***
 * This interface for notes and coins
 */
public interface Money {
    int getCurrentCount();
    void setCurrentCount(int count);

    String getNoteType();
}

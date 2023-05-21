package com.contal.group.model.money;

/***
 * This interface controls the common function each money value anc amount (like 50 notes, 20note, and so on)
 */
public interface Money {
    int getCurrentCount();
    void setCurrentCount(int count);

    String getNoteType();
}

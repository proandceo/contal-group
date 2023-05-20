package com.contal.group.model.device;

import com.contal.group.model.money.Notes;
import com.contal.group.model.people.Client;
import com.contal.group.model.people.Manager;
import com.contal.group.model.people.People;

public class Device {
    private People manger;
    private People client;
    private String type;
    private final Notes fiftyNote;
    private final Notes twentyNote;

    /*
    This device have a supply of cash available for 50 notes and 20 notes
    and initialisation.
     */
    public Device(){
        fiftyNote = new Notes("50", 30);
        twentyNote = new Notes("20", 30);
    }

    public String getType(People people){
        if (people instanceof Manager){
            manger = new Manager("RexPark", "contal");
            type = "manager";
        }

        if (people instanceof Client){
            client = new Client("123456", "4321");
            type = "client";
        }

        return type;
    }

    public void addNote(String noteType, int account){
        if (noteType.equals(fiftyNote.getNoteType())){
            fiftyNote.addNote(account);
        }

        if (noteType.equals(twentyNote.getNoteType())){
            twentyNote.addNote(account);
        }
    }

    public void removeNote(String noteType, int account){
        if (noteType.equals(fiftyNote.getNoteType())){
            fiftyNote.removeNote(account);
        }

        if (noteType.equals(twentyNote.getNoteType())){
            twentyNote.removeNote(account);
        }
    }

    public String checkHowMuchMoneyHasIn(){
        return toString();
    }

    /*
    report how much of each note is has
     */
    @Override
    public String toString(){
        return fiftyNote.toString() + "||" + twentyNote.toString();
    }


}

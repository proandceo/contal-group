package com.contal.group.service.device;

import com.contal.group.model.money.Notes;
import com.contal.group.model.people.Client;
import com.contal.group.model.people.Admin;
import com.contal.group.model.people.People;

/**
 * about Device like ATM
 */
public class DeviceService {
    Admin admin;
    Client client;
    String type;
    static Notes fiftyNote;
    static Notes twentyNote;

    static{
        fiftyNote = new Notes("50", 100);
        twentyNote = new Notes("20", 100);
    }

    /*
    This device have a supply of cash available for 50 notes and 20 notes.
     */
    public DeviceService(People people){
        if (people instanceof Admin) {
            admin = (Admin)people;
            type = "admin";
        }

        if (people instanceof Client) {
            client = (Client)people;
            type = "client";
        }
    }

    public Client getClient(){
        return client;
    }
    public Admin getAdmin() {return admin;}

    public String getType(){
        return type;
    }

    /**
     * only administrator can add notes
     */
    public void addNote(String type, String noteType, int account){
        if ("admin".equals(type)) {
            if (noteType.equals(fiftyNote.getNoteType())) {
                fiftyNote.addNote(account);
            }

            if (noteType.equals(twentyNote.getNoteType())) {
                twentyNote.addNote(account);
            }
        }
    }

    /**
     * when notes like $50, $20 are removed or withdrawn, the total number is also decreased.
     */
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

    public synchronized int withdrawMoney(Client client, int money){
        client.getAccount().setBalance(client.getAccount().getAccountNum(), client.getAccount().getPassword());
        int balanceOfClient = client.getAccount().getBalance();
        int countFiftyNote = fiftyNote.getCurrentCount();
        int countTwentyNote = twentyNote.getCurrentCount();

        final int[] style = new CashWithdrawService().checkAmountWithdraw(money);
        if (style == null) return 0;
        int balance = 0;

        try {
            new CashWithdrawService().cashDispensing(money);
            balance = client.getAccount().withdrawMoney(money);

        } catch (Exception e){
            unhandledEvent(client, balanceOfClient, countFiftyNote, countTwentyNote);
        }
        return balance;
    }

    private static void unhandledEvent(Client client, int balanceOfClient, int countFiftyNote, int countTwentyNote) {
        client.getAccount().setBalance(client.getAccount().getAccountNum(), client.getAccount().getPassword());
        if (balanceOfClient > client.getAccount().getBalance())
            client.getAccount().setBalance(balanceOfClient);

        if (countFiftyNote > fiftyNote.getCurrentCount())
            fiftyNote.setCurrentCount(countFiftyNote);

        if (countTwentyNote > twentyNote.getCurrentCount())
            twentyNote.setCurrentCount(countTwentyNote);
    }

    /*
    report how much of each note is has
     */
    @Override
    public String toString(){
        return fiftyNote + "||" + twentyNote;
    }
}

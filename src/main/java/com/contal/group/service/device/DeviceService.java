package com.contal.group.service.device;

import com.contal.group.model.money.Notes;
import com.contal.group.model.people.Client;
import com.contal.group.model.people.Admin;
import com.contal.group.model.people.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeviceService {
    Admin admin;
    Client client;
    String type;
    static Notes fiftyNote;
    static Notes twentyNote;
    static final Logger log = LoggerFactory.getLogger(DeviceService.class);

    static{
        fiftyNote = new Notes("50", 100);
        twentyNote = new Notes("20", 100);
    }

    /*
    This device have a supply of cash available for 50 notes and 20 notes
    and initialisation.
     */
    public DeviceService(People people){
        if (people instanceof Admin) {
            admin = (Admin)people;
            type = "manager";
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

    public void addNote(String type, String noteType, int account){
        if ("manager".equals(type)) {
            if (noteType.equals(fiftyNote.getNoteType())) {
                fiftyNote.addNote(account);
            }

            if (noteType.equals(twentyNote.getNoteType())) {
                twentyNote.addNote(account);
            }
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

    public synchronized void withdrawMoney(Client client, int money){
        client.getAccount().setBalance(client.getAccount().getAccountNum(), client.getAccount().getPassword());
        int balanceOfClient = client.getAccount().getBalance();
        int countFiftyNote = fiftyNote.getCurrentCount();
        int countTwentyNote = twentyNote.getCurrentCount();

        if (money % 10 != 0){
            log.info("Unable to withdraw");
        }
        try {
            new CashWithdrawService().cashDispensing(money);
            client.getAccount().withdrawMoney(money);

        } catch (Exception e){
            client.getAccount().setBalance(client.getAccount().getAccountNum(), client.getAccount().getPassword());
            if (balanceOfClient > client.getAccount().getBalance())
                client.getAccount().setBalance(balanceOfClient);

            if (countFiftyNote > fiftyNote.getCurrentCount())
                fiftyNote.setCurrentCount(countFiftyNote);

            if (countTwentyNote > twentyNote.getCurrentCount())
                twentyNote.setCurrentCount(countTwentyNote);
        }
    }

    /*
    report how much of each note is has
     */
    @Override
    public String toString(){
        return fiftyNote + "||" + twentyNote;
    }
}

package com.contal.group.model.people;

public class Client implements People {

    private final String accountNum;
    private final String pass;

    public Client(String accountNum, String pass){
        this.accountNum = accountNum;
        this.pass = pass;
    }

    @Override
    public String id(){
        return accountNum;
    }

    @Override
    public String pass(){
        return pass;
    }


}

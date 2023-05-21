package com.contal.group.model.people;

public class Admin implements People {

    private final String id;
    private final String pass;

    public Admin(String id, String pass){
        this.id = id;
        this.pass = pass;
    }

    public String getId(){
        return id;
    }

    public String getPass(){
        return pass;
    }

}

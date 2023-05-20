package com.contal.group.model.people;

public class Manager implements People {

    private final String id;
    private final String pass;

    public Manager(String id, String pass){
        this.id = id;
        this.pass = pass;
    }

    public String getId(){
        return id;
    }

    @Override
    public String getPass(){
        return pass;
    }

}

package com.contal.group.model.people;

/**
 * administrator
 */
public class Admin implements People {

    String id;
    String pass;

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

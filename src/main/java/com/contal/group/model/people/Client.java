package com.contal.group.model.people;

import com.contal.group.model.bank.Account;

public class Client implements People {

    private final String accountNum;
    private final String pass;
    private final Account account;

    public Client(String accountNum, String pass, Account account) {
        this.accountNum = accountNum;
        this.pass = pass;
        this.account = account;
    }

    public String getAccountNum(){
        return accountNum;
    }

    @Override
    public String getPass(){
        return pass;
    }

    public Account getAccount(){
        return account;
    }
}

package com.contal.group.model.people;

import com.contal.group.model.bank.Account;

public class Client implements People {

    private final Account account;

    public Client(Account account) {
        this.account = account;
    }

    public Account getAccount(){
        return account;
    }
}

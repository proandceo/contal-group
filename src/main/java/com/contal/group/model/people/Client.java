package com.contal.group.model.people;

import com.contal.group.model.bank.Account;

/**
 * control client
 */
public class Client implements People {

    Account account;

    public Client(Account account) {
        this.account = account;
    }

    public Account getAccount(){
        return account;
    }
}

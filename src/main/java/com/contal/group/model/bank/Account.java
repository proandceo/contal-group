package com.contal.group.model.bank;

public class Account {

    private final String accountNum;
    private final String password;
    private int balance;

    public Account(String accountNum, String password, int balance){
        this.accountNum = accountNum;
        this.password = password;
        this.balance = balance;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getPassword() {
        return password;
    }

    public synchronized int saveMoney(int money){
        return this.balance += money;
    }

    public synchronized int withdrawMoney(int money){
        return this.balance -= money;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString(){
        return balance + "in my account has left";
    }
}

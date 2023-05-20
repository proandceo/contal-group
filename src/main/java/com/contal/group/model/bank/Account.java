package com.contal.group.model.bank;

public class Account {

    private int money;

    public Account(int money){
        this.money = money;
    }

    public synchronized int saveMoney(int money){
        return this.money += money;
    }

    public synchronized int withdrawMoney(int money){
        return this.money -= money;
    }

    public int getBalance(){
        return money;
    }

    @Override
    public String toString(){
        return money + "in my account has left";
    }
}

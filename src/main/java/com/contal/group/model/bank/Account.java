package com.contal.group.model.bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The information of Client account
 * - account number
 * - password
 * - balance
 */
public class Account {

    String accountNum;
    String password;
    int balance;

    public Account(String accountNum, String password){
        this.accountNum = accountNum;
        this.password = password;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(String accountNum, String password){
        List<String[]> arr = readClientInfo();

        int size = 0;
        int balance = 0;
        while(arr.size() > size) {
            if(accountNum.equals(arr.get(size)[0])
                    && password.equals(arr.get(size)[1])){
                balance = Integer.parseInt(arr.get(size)[2]);
                break;
            }
            size++;
        }

        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    private static List<String[]> readClientInfo() {
        List<String[]> arr = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("client.txt").getAbsoluteFile()));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String[] line = str.split(",");
                arr.add(line);
            }

            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return arr;
    }

    public synchronized int saveMoney(int money){
        return this.balance += money;
    }

    public synchronized int withdrawMoney(int money){
        return this.balance -= money;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString(){
        return balance + "in my account has left";
    }
}

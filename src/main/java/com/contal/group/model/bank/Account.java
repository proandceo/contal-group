package com.contal.group.model.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    /**
     * get Balance from accountNum, password in client's information file(client.txt)
     */
    public void setBalance(String accountNum, String password){
        List<String[]> arr = readClientInfoFromFile();

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

    /**
     * read the information of client which is accountNum, password and balance
     *
     */
    private List<String[]> readClientInfoFromFile() {
        List<String[]> arr = new ArrayList<>();
        String fileName = "client.txt";
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            for (String str:stream.toList()) {
                String[] line = str.split(",");
                arr.add(line);
            }
        }catch (IOException e){
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
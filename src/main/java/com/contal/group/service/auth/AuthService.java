package com.contal.group.service.auth;

import com.contal.group.model.people.Admin;
import com.contal.group.model.people.Client;
import com.contal.group.model.people.People;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    String file;

    public AuthService(People people){
        if(people instanceof Admin){
            file = "admin.txt";
        }

        if(people instanceof Client){
            file = "client.txt";
        }
    }

    public String getFile(){
        return file;
    }

    public List<String[]> readFileInfo(File file) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        String str;
        List<String[]> arr = new ArrayList<>();

        while ((str = bufferedReader.readLine()) != null) {
            String[] line = str.split(",");
            arr.add(line);
        }

        bufferedReader.close();
        return arr;
    }

    public boolean authClient(Client client, File cfile){
        try {
            int size = 0;
            while (readFileInfo(cfile).size() > size) {
                if ((client.getAccount().getAccountNum()).equals(readFileInfo(cfile).get(size)[0])
                        && (client.getAccount().getPassword()).equals(readFileInfo(cfile).get(size)[1])) {
                    return true;
                }
                size++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean authAdmin(Admin admin, File afile) throws Exception{
        int size = 0;
        while(readFileInfo(afile).size() > size) {
            if((admin.getId()).equals(readFileInfo(afile).get(size)[0])
                    && (admin.getPass()).equals(readFileInfo(afile).get(size)[1])){
                return true;
            }
            size++;
        }
        return false;
    }
}

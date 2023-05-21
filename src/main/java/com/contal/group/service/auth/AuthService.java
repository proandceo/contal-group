package com.contal.group.service.auth;

import com.contal.group.model.people.Admin;
import com.contal.group.model.people.Client;
import com.contal.group.model.people.People;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * There are two files for saving the information of administrator and client
 * for administrator, "admin.txt"
 * - id and pass are included
 * for client, "client.txt"
 * - accountNum,password,balance are saved.
 */
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

    /**
     * to read files for authorisation
     */
    public List<String[]> readFileInfo(File file){
        List<String[]> arr = new ArrayList<>();

        try(Stream<String> stream = Files.lines(Paths.get(file.getName()))){
            for (String str:stream.toList()) {
                String[] line = str.split(",");
                arr.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return arr;
    }

    /**
     * validate who is the right person to use device.
     */
    public boolean authPeople(People people, File file){
        int size = 0;
        if(people instanceof Client){
            while (readFileInfo(file).size() > size) {
                if ((((Client)people).getAccount().getAccountNum()).equals(readFileInfo(file).get(size)[0])
                        && (((Client)people).getAccount().getPassword()).equals(readFileInfo(file).get(size)[1])) {
                    return true;
                }
                size++;
            }
        }

        if (people instanceof Admin){
            while(readFileInfo(file).size() > size) {
                if((((Admin)people).getId()).equals(readFileInfo(file).get(size)[0])
                        && (((Admin)people).getPass()).equals(readFileInfo(file).get(size)[1])){
                    return true;
                }
                size++;
            }
        }
        return false;
    }
}

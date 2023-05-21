package com.contal.group.service.auth;

import com.contal.group.model.bank.Account;
import com.contal.group.model.people.Admin;
import com.contal.group.model.people.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthTest {
    Auth clientAuth;
    Auth adminAuth;
    Client client;
    Admin admin;

    @BeforeEach
    void beforeEach(){
        client = new Client(new Account("123456", "0987", 1000));
        clientAuth = new Auth(client);

        admin = new Admin("1234111", "0987");
        adminAuth = new Auth(admin);
    }

    @DisplayName("find the location of file")
    @Test
    void testGetFile(){
        //given
        //when
        File file = new File(clientAuth.getFile());
        //then
        assertEquals("client.txt", file.getPath());

    }

    @DisplayName("read admin and client files")
    @Test
    void testReadFile() throws Exception{
        //given
        String clientFile = clientAuth.getFile();
        String adminFile = adminAuth.getFile();

        //when
        File cfile = new File(clientFile);
        File afile = new File(adminFile);

        //then
        assertEquals("123456",clientAuth.readFileInfo(cfile).get(0)[0]);
        assertEquals("1234111",clientAuth.readFileInfo(afile).get(0)[0]);
    }

    @DisplayName("Check authorization of Client")
    @Test
    void testClientValidation() throws Exception{
        //given
        String clientFile = clientAuth.getFile();

        //when
        File cfile = new File(clientFile);

        //then
        assertTrue(clientAuth.authClient(client, cfile));

    }

    @DisplayName("Check authorization of Admin")
    @Test
    void testAdminValidation() throws Exception{
        //given
        String adminFile = adminAuth.getFile();

        //when
        File afile = new File(adminFile);

        //then
        assertTrue(adminAuth.authAdmin(admin, afile));
    }

}

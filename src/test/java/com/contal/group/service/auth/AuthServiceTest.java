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

public class AuthServiceTest {
    AuthService clientAuthService;
    AuthService adminAuthService;
    Client client;
    Admin admin;

    @BeforeEach
    void beforeEach(){
        client = new Client(new Account("123456", "0987"));
        clientAuthService = new AuthService(client);

        admin = new Admin("1234111", "0987");
        adminAuthService = new AuthService(admin);
    }

    @DisplayName("find the location of file")
    @Test
    void testGetFile(){
        //given
        //when
        File file = new File(clientAuthService.getFile());
        //then
        assertEquals("client.txt", file.getPath());

    }

    @DisplayName("read admin and client files")
    @Test
    void testReadFile() throws Exception{
        //given
        String clientFile = clientAuthService.getFile();
        String adminFile = adminAuthService.getFile();

        //when
        File cfile = new File(clientFile);
        File afile = new File(adminFile);

        //then
        assertEquals("123456", clientAuthService.readFileInfo(cfile).get(0)[0]);
        assertEquals("1234111", clientAuthService.readFileInfo(afile).get(0)[0]);
    }

    @DisplayName("Check authorization of Client")
    @Test
    void testClientValidation(){
        //given
        String clientFile = clientAuthService.getFile();

        //when
        File cfile = new File(clientFile);

        //then
        assertTrue(clientAuthService.authClient(client, cfile));

    }

    @DisplayName("Check authorization of Admin")
    @Test
    void testAdminValidation() throws Exception{
        //given
        String adminFile = adminAuthService.getFile();

        //when
        File afile = new File(adminFile);

        //then
        assertTrue(adminAuthService.authAdmin(admin, afile));
    }

}

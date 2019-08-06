package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.User;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class UserControllerTest {

    User user = new User("1","Jinnew Chyi","123","13389773421","gabralia@gmail.com");

    private UserController userController = new UserController();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setIn(System.in);
        System.setOut(null);
    }

    @Before
    public void addUser() {
        userController.addUser(user);
    }

    @Test
    public void userCanLogin(){
        setUserLoginInfo("1\n","123\n");
        assertThat(userController.login(), is(true));
    }

    @Test
    public void userCannotLogin(){
        setUserLoginInfo("2\n","sss\n");
        assertThat(userController.login(), is(false));
    }

    @Test
    public void userCanViewInformation(){
        setUserLoginInfo("1\n","123\n");
        userController.login();
        userController.showUserInformation();
        assertThat(outContent.toString(),containsString(String.format(
                "%-30s%-30s%-30s%-30s%n",
                user.getId(),
                user.getName(),
                user.getPhone(),
                user.getEmail()
        )));
    }

    @Test
    public void userCannotViewInformation(){
        userController.logout();
        userController.showUserInformation();
        assertThat(outContent.toString(),containsString("No user information"));
    }

    @Test
    public void getCurrentUser(){
        assertThat(UserController.getCurrentUser(), is("1"));
    }

    private void setUserLoginInfo(String id, String password){
        ByteArrayInputStream in1 = new ByteArrayInputStream(id.getBytes());
        ByteArrayInputStream in2 = new ByteArrayInputStream(password.getBytes());
        SequenceInputStream in = new SequenceInputStream(in1,in2);
        System.setIn(in);
    }
}

package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class UserControllerTest {

    private UserController userController = new UserController();

    @Before
    public void addUser() {
        User user = new User("1","Jinnew Chyi","123","13389773421","gabralia@gmail.com");
        userController.addUser(user);
    }

    @Test
    public void userCanLogin(){
        ByteArrayInputStream in1 = new ByteArrayInputStream("1\n".getBytes());
        ByteArrayInputStream in2 = new ByteArrayInputStream("123\n".getBytes());
        SequenceInputStream in = new SequenceInputStream(in1,in2);
        System.setIn(in);
        assertThat(userController.login(), is(true));
    }

    @Test
    public void userCanNotLogin(){
        ByteArrayInputStream in1 = new ByteArrayInputStream("2\n".getBytes());
        ByteArrayInputStream in2 = new ByteArrayInputStream("sss\n".getBytes());
        SequenceInputStream in = new SequenceInputStream(in1,in2);
        System.setIn(in);
        assertThat(userController.login(), is(false));
    }

    @Test
    public void getCurrentUser(){
        assertThat(UserController.getCurrentUser(), is("1"));
    }
}

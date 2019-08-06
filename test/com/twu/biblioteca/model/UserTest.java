package com.twu.biblioteca.model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    private User user = new User("1","Jinnew Chyi","123","13389773421","gabralia@gmail.com");

    @Test
    public void getId(){
        assertThat(user.getId(),is("1"));
    }

    @Test
    public void getName(){
        assertThat(user.getName(),is("Jinnew Chyi"));
    }

    @Test
    public void getPassword(){
        assertThat(user.getPassword(),is("123"));
    }

    @Test
    public void getPhone(){
        assertThat(user.getPhone(),is("13389773421"));
    }

    @Test
    public void getEmail(){
       assertThat(user.getEmail(),is("gabralia@gmail.com"));
    }
}

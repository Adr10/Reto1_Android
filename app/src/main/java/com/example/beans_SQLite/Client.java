package com.example.beans_SQLite;

import java.io.Serializable;
import java.util.Objects;


public class Client implements Serializable {

    private int id;
    private String LoginUser;
    private String Pass;


    public Client(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginUser() {
        return LoginUser;
    }

    public void setLoginUser(String loginUser) {
        LoginUser = loginUser;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && LoginUser.equals(client.LoginUser) && Pass.equals(client.Pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, LoginUser, Pass);
    }
}
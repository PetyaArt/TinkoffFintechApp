package com.example.petya.tinkofffintech.network;

public class SingInBody {
    public String email;
    public String password;

    public SingInBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

package com.example.a1555108.gestioncampdejour.Singleton;

import com.example.a1555108.gestioncampdejour.Classes.User;

public class SingletonUserTest {
    private  static User userConnected;
    private static SingletonUserTest ourInstance;



    public static SingletonUserTest getInstance() {
        if (ourInstance == null){
            ourInstance = new SingletonUserTest();
        }
        return ourInstance;
    }

    private SingletonUserTest() {
        //Priate to prevent ppl to instantiate this
    }

    public  User getUserConnected() {
        return userConnected;
    }
    public void setUserConnected(User user) {
        userConnected = user;
    }
}

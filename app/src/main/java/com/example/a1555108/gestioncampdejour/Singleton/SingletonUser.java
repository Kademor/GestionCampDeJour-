package com.example.a1555108.gestioncampdejour.Singleton;

import com.example.a1555108.gestioncampdejour.Classes.User;

public class SingletonUser {
    private  static User userConnected;
    private static SingletonUser ourInstance;



    public static SingletonUser getInstance() {
        if (ourInstance == null){
            ourInstance = new SingletonUser();
        }
        return ourInstance;
    }

    private SingletonUser() {
        //Priate to prevent ppl to instantiate this
    }

    public void logOut(){
        ourInstance = new SingletonUser();
    }
    public  User getUserConnected() {
        return userConnected;
    }
    public void setUserConnected(User user) {
        userConnected = user;
    }
}

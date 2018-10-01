package com.example.a1555108.gestioncampdejour.Singleton;

import android.content.Context;

import com.example.a1555108.gestioncampdejour.Classes.User;
import com.squareup.otto.Bus;

public class SingletonUser {
    public Bus bus;
    private static SingletonUser instance;
    public User connectedUser;

    public SingletonUser(Context c){
        bus = new Bus();
    }

    public  void init(Context c){
        if(instance == null){
            instance = new SingletonUser(c);
        }else{throw new IllegalMonitorStateException("Instance deja partie");}
    }

    public  SingletonUser get(Context c){
        if(instance == null){
            throw new IllegalMonitorStateException("hey non");
        }else{return instance;}
    }
}

package com.example.a1555108.gestioncampdejour.Singleton;

import android.content.Context;

import com.squareup.otto.Bus;

public class Singleton {
    Bus bus;
    private static Singleton instance;

    private Singleton(Context c){
        bus = new Bus();
    }

    private static void init(Context c){
        if(instance == null){
            instance = new Singleton(c);
        }else{throw new IllegalMonitorStateException("hey non");}
    }

    private static Singleton get(Context c){
        if(instance == null){
            throw new IllegalMonitorStateException("hey non");
        }else{return instance;}
    }

}

package com.example.a1555108.gestioncampdejour.Singleton;

import com.example.a1555108.gestioncampdejour.Classes.Camper;
import com.example.a1555108.gestioncampdejour.Classes.User;

public class SingletonCamper {
    private  static Camper selectedCamper;
    private static SingletonCamper ourInstance;



    public static SingletonCamper getInstance() {
        if (ourInstance == null){
            ourInstance = new SingletonCamper();
        }
        return ourInstance;
    }

    private SingletonCamper() {
        //Priate to prevent ppl to instantiate this
    }

    public  Camper getUserConnected() {
        return selectedCamper;
    }
    public void setUserConnected(Camper camper) {
        selectedCamper = camper;
    }
}


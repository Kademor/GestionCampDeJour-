package com.example.a1555108.gestioncampdejour.Classes;

import android.app.Application;
import android.content.Intent;

import com.example.a1555108.gestioncampdejour.Activites.AddCamperActivity;
import com.example.a1555108.gestioncampdejour.Activites.ListActivity;
import com.example.a1555108.gestioncampdejour.Activites.LoginActivity;
import com.example.a1555108.gestioncampdejour.R;

public class DrawerCopy {

//nav utils
    public void laSwitch(Application appli, int id){
        switch(id){
            case R.id.navigation_item_1:
                Intent i = new Intent(appli.getApplicationContext(),ListActivity.class);
                User user = new User("philippe" , "Morin" , "Merlin", " mdp");
                appli.startActivity(i);
                break;
            case R.id.navigation_item_2:
                Intent i2 = new Intent(appli.getApplicationContext(),AddCamperActivity.class);
                appli.startActivity(i2);
                break;
            case R.id.navigation_item_3:
                Intent i3 = new Intent(appli.getApplicationContext(),LoginActivity.class);
                appli.startActivity(i3);
            default: break;
        }

    }

}

package com.example.a1555108.gestioncampdejour.Classes;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.TextView;

import com.example.a1555108.gestioncampdejour.Activites.AddCamperActivity;
import com.example.a1555108.gestioncampdejour.Activites.ListActivity;
import com.example.a1555108.gestioncampdejour.Activites.LoginActivity;
import com.example.a1555108.gestioncampdejour.R;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonUser;

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
                i3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SingletonUser s = SingletonUser.getInstance();
                s.logOut();
                appli.startActivity(i3);
            default: break;
        }
    }

    public void setUpCampName(ListActivity a){
        SingletonUser sing = SingletonUser.getInstance();
        NavigationView navView = (NavigationView) a.findViewById(R.id.navBar);
        View headerView = navView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.HeaderNavPlease);
        navUsername.setText(sing.getUserConnected().getCampName());
    }

}

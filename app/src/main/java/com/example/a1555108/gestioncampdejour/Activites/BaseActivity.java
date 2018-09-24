package com.example.a1555108.gestioncampdejour.Activites;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a1555108.gestioncampdejour.Adapteurs.adapterCamperList;
import com.example.a1555108.gestioncampdejour.R;

public class BaseActivity extends AppCompatActivity {

    ActionBarDrawerToggle toggle;
    public DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


        NavigationView navBar =(NavigationView) findViewById(R.id.navBar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_Layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navBar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(getApplicationContext(), "item " + item , Toast.LENGTH_SHORT).show();
                if (item.getItemId() == R.id.navigation_item_1){

                }
                drawerLayout.closeDrawers();
                return  false;
            }
        });
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open_drawer, R.string.close_drawer){
        };
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    //Faire fonctionner hamburger
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Faire en sorte que ca ne brise pas en rotate(nav)
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }
    //Faire en sorte que ca ne brise pas en rotate(nav)
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        toggle.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }
}

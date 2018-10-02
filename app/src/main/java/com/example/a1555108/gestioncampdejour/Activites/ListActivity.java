package com.example.a1555108.gestioncampdejour.Activites;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1555108.gestioncampdejour.Adapteurs.adapterCamperList;
import com.example.a1555108.gestioncampdejour.Classes.CamperList;
import com.example.a1555108.gestioncampdejour.Classes.DrawerCopy;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.RetroFitUtils;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.ServiceService;
import com.example.a1555108.gestioncampdejour.R;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    adapterCamperList adapter;
    ActionBarDrawerToggle toggle;
    DrawerCopy methodesDrawer = new DrawerCopy();
    ServiceService service = RetroFitUtils.getMock();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView lv = (ListView) findViewById(R.id.lv_camper_list);
        adapter = new adapterCamperList(this);
        setListeCamperMock();
        lv.setAdapter(adapter);

        //NAV BAR SETUP
        //petite fleche
        //singleton show user
        SingletonUser sing = SingletonUser.getInstance();
        NavigationView navView = (NavigationView) findViewById(R.id.navBar);
        View headerView = navView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.HeaderNavPlease);
        navUsername.setText(sing.getUserConnected().getCampName());

        View inflatedView = getLayoutInflater().inflate(R.layout.drawer_header, null);
        TextView tv2 = findViewById(R.id.HeaderNavPlease);
        TextView tv = inflatedView.findViewById(R.id.HeaderNavPlease);
        tv.setText("helllo");

        NavigationView navBar =(NavigationView) findViewById(R.id.navBar);
        final DrawerLayout drawer_layout = (DrawerLayout) findViewById(R.id.drawer_Layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navBar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                methodesDrawer.laSwitch(getApplication(),item.getItemId());
                drawer_layout.closeDrawers();
                return  false;
            }
        });
        toggle = new ActionBarDrawerToggle(this, drawer_layout,R.string.open_drawer, R.string.close_drawer){
        };
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
        //Fin nav bar setup


        //Bouton add camper
        Button btnAddCamp = (Button) findViewById(R.id.btnAddCamper);
        btnAddCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddCamperActivity.class);
                startActivity(i);
            }
        });


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

    public void setListeCamperMock(){
        service.getCamperList().enqueue(new Callback<ArrayList<CamperList>>() {
            @Override
            public void onResponse(Call<ArrayList<CamperList>> call, Response<ArrayList<CamperList>> response) {
                if (response.isSuccessful()){
                    adapter.addAll(response.body());
                }
                else {
                    Log.i("ERREURMOCK", String.valueOf(response.code()));
                }
            }
            @Override
            public void onFailure(Call<ArrayList<CamperList>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Failed to connect",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

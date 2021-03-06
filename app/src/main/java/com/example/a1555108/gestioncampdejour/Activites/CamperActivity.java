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
import android.view.View;
import android.widget.TextView;

import com.example.a1555108.gestioncampdejour.Classes.Camper;
import com.example.a1555108.gestioncampdejour.Classes.DrawerCopy;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.RetroFitUtils;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.ServiceService;
import com.example.a1555108.gestioncampdejour.R;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonCamper;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonUser;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CamperActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
    DrawerCopy methodesDrawer = new DrawerCopy();
    Camper currentCamper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camper);

        //NAV BAR SETUP
        //petite fleche

        //Setup^nom
        SingletonUser sing = SingletonUser.getInstance();
        NavigationView navView = (NavigationView) findViewById(R.id.navBar);
        View headerView = navView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.HeaderNavPlease);
        navUsername.setText(sing.getUserConnected().getCampName());
        //Setup^nom

        setUpInfosCamper();
        //set

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

    }


    public void setUpInfosCamper(){
        SingletonCamper sing = SingletonCamper.getInstance();
        currentCamper = sing.getSelectedCamper();

        TextView textViewName = findViewById(R.id.camperName);
        textViewName.setText(currentCamper.getFirstName());

        TextView textViewLastName = findViewById(R.id.camperLastName);
        textViewLastName.setText(currentCamper.getLastName());

        TextView textViewAlergies = findViewById(R.id.camperAlergies);
        textViewAlergies.setText(currentCamper.getAlergies());

        TextView textViewNumber = findViewById(R.id.camperNumber);
        textViewNumber.setText(currentCamper.getEmergencyNumber());

        TextView textViewCase = findViewById(R.id.camperCase);
        textViewCase.setText(currentCamper.getSpecialCase());


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

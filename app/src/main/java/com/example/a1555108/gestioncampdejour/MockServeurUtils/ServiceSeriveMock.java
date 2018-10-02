package com.example.a1555108.gestioncampdejour.MockServeurUtils;

import com.example.a1555108.gestioncampdejour.Classes.Camper;
import com.example.a1555108.gestioncampdejour.Classes.CamperList;
import com.example.a1555108.gestioncampdejour.Classes.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.mock.BehaviorDelegate;

public class ServiceSeriveMock implements ServiceService{


    BehaviorDelegate<ServiceService> delegate;

    public ServiceSeriveMock(BehaviorDelegate<ServiceService> delegate){
        this.delegate = delegate;
    }

    @Override
    public Call<String> racine() {
        return  delegate.returningResponse("Hello mock mock").racine();
    }

    @Override
    public Call<User> getUser() {
        User user = new User("Philippe","Morin" , "Merlin" ,"Password");
        return delegate.returningResponse(user).getUser();
    }

    @Override
    public Call<Camper> getCamper() {
        ArrayList<String> allergiess = new ArrayList<String>();
        allergiess.add("Malaria");
        return delegate.returningResponse(new Camper(1,"josh", "tremblay", allergiess, "12", "k")).getCamper();
    }

    @Override
    public Call<ArrayList<CamperList>> getCamperList() {
            CamperList josh = new CamperList(1,"josh", "tremblay");
            CamperList jean = new CamperList(2,"jean", "tremblay");
            CamperList bob = new CamperList(3,"bob", "tremblay");

            ArrayList<CamperList> listNomCampeurs = new ArrayList<>();
            listNomCampeurs.add(josh);
            listNomCampeurs.add(jean);
            listNomCampeurs.add(bob);

        return delegate.returningResponse(listNomCampeurs).getCamperList();

    }


}

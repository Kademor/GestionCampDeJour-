package com.example.a1555108.gestioncampdejour.MockServeurUtils;

import com.example.a1555108.gestioncampdejour.Classes.Camper;
import com.example.a1555108.gestioncampdejour.Classes.CamperList;
import com.example.a1555108.gestioncampdejour.Classes.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceService {
    @GET("/users/jorisdeguet/repos")
    Call<String> racine();

    @GET("/")
    Call<User> getUser(String campName, String password);

    @GET("/")
    Call<Camper> getCamper(int camperId);

    @GET("/")
    Call<ArrayList<CamperList>> getCamperList();

    @POST Call<User> createUser(User user);

    @POST Call<Camper> createCamper(Camper camper);


}

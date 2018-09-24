package com.example.a1555108.gestioncampdejour.MockServeurUtils;

import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

public class RetroFitUtils {
    public static  ServiceService get(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        ServiceService service = retrofit.create(ServiceService.class);

        return service;
    }

    public static  ServiceService getMock(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        //ServiceService service = retrofit.create(ServiceService.class);

        NetworkBehavior networkBehavior = NetworkBehavior.create();
        networkBehavior.setDelay(1000, TimeUnit.MILLISECONDS);
        networkBehavior.setVariancePercent(90);

        MockRetrofit mock = new MockRetrofit.Builder(retrofit)
                .networkBehavior(networkBehavior)
                .build();
        BehaviorDelegate<ServiceService> delegate = mock.create(ServiceService.class);

        return new ServiceSeriveMock(delegate);


       // return service;
    }

}

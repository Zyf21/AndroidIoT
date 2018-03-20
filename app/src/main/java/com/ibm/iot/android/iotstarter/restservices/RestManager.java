package com.ibm.iot.android.iotstarter.restservices;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ded2 on 19.03.2018.
 */

public class RestManager {

    private IRest iTests;

    public RestManager(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://178.172.209.29:8888/iot-server-be/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iTests = retrofit.create(IRest.class);
    }


    public void postLightbulb(Callback<Void> callback) {
        Call<Void> result = iTests.postLightbulb();
        result.enqueue(callback);
    }

    public void setLightColor(int red, int green, int blue, Callback<Void> callback) {
        Call<Void> result = iTests.setLightColor(red, green, blue);
        result.enqueue(callback);
    }
    public void postDefault(Callback <Void> callback)
    {
        Call<Void> result = iTests.postDefault();
        result.enqueue(callback);
    }
    public void postOn (Callback <Void> callback)

    {
        Call <Void> result = iTests.postOn();
        result.enqueue(callback);
    }

    public  void  postOff (Callback <Void> callback)
    {
        Call <Void> result =iTests.postOff();
        result.enqueue(callback);
    }


}

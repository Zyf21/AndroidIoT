package com.ibm.iot.android.iotstarter.restservices;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ded2 on 19.03.2018.
 */

public interface IRest {
    @POST("light/toggle")
    Call<Void> postLightbulb();

    @POST("light/color/")
    Call<Void> setLightColor(@Query("red")   Integer red,
                             @Query("green") Integer green,
                             @Query("blue")  Integer blue);

    @POST ("light/default")
    Call<Void>postDefault();

    @POST("light/night/on")
    Call<Void>postOn();

    @POST ("light/night/off")
    Call <Void> postOff();


}

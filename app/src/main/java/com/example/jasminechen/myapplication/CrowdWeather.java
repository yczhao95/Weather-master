package com.example.jasminechen.myapplication;

/**
 * Created by jasminechen on 18/2/4.
 */
import com.firebase.client.Firebase;
public class CrowdWeather extends android.app.Application{

    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}

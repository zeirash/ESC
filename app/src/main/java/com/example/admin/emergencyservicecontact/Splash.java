package com.example.admin.emergencyservicecontact;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    DbHandler myDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences sp = this.getSharedPreferences("Checking", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        final Boolean isInputDB = sp.getBoolean("checkingInputDB", false);

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try{
                    if(!isInputDB) {
                        myDbHandler = new DbHandler(getApplicationContext(), null);
                        myDbHandler.inputData();
                        editor.putBoolean("checkingInputDB", true).commit();
                    }
                    Intent intent = new Intent(getApplicationContext(), LandingPage.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        myThread.start();
    }

}

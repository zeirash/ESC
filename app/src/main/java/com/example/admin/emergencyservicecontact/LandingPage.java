package com.example.admin.emergencyservicecontact;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class LandingPage extends AppCompatActivity {

    Intent intent;
    DbHandler myDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        myDbHandler = new DbHandler(this, null);
        //get data dri class DbHandler
        ArrayList<String> listNation = myDbHandler.getNationName();
        //masukin data k spinner dri database
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.spinner_text, listNation);
        spinner.setPrompt("Select country");
        spinner.setAdapter(spinnerAdapter);
        //spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }
    
    public void onClickConfirm(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String nationResult = spinner.getSelectedItem().toString();

        SharedPreferences sp = this.getSharedPreferences("nationResultData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nationNamePassData", nationResult);
        editor.commit();

        SharedPreferences sp2 = this.getSharedPreferences("Checking", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sp2.edit();
        editor2.putBoolean("checkingFirstRun", false).commit();

        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        SharedPreferences sp = this.getSharedPreferences("Checking", Context.MODE_PRIVATE);
        Boolean isFirstRun = sp.getBoolean("checkingFirstRun", true);
        //checking first run
        if(isFirstRun) {
            intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        else super.onBackPressed();
        /*intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
        super.onBackPressed();*/
    }
}

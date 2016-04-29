package com.example.admin.emergencyservicecontact;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
        spinner.setAdapter(spinnerAdapter);
        //spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }

    //kenapa lemot kalau di klik confirm
    public void onClickConfirm(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        intent = new Intent(this, MainActivity.class);
        String nationResult = spinner.getSelectedItem().toString();
        intent.putExtra("nationResult", nationResult);
        startActivity(intent);
    }

}

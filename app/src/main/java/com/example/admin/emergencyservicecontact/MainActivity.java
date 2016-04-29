package com.example.admin.emergencyservicecontact;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.support.v7.app.ActionBarDrawerToggle;


public class MainActivity extends AppCompatActivity {

    Intent intent;
    DbHandler myDbHandler;
    public String nationPassData;
    DrawerLayout drawerLayout;
    //ActionBarDrawerToggle toogle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        myDbHandler = new DbHandler(this, null);
        //input data ke database hrs pake sharedpreference
        myDbHandler.inputData();

        Bundle nationNameFromLandingPage = getIntent().getExtras();
        if(nationNameFromLandingPage == null) {
            return;
        }
        nationPassData = nationNameFromLandingPage.getString("nationResult");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView titleText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //ganti title sesuai nation yg dipilih
        titleText.setText(nationPassData);

        //toogle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        //drawerLayout.addDrawerListener(toogle);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        switch(item.getItemId()) {
                            //gimana cara pindah ke landingpage activity
                            case R.id.settings_id:
                                goToLandingPage();
                                break;
                        }

                        startActivity(intent);
                        return true;
                    }
                }
        );
    }

    public void goToLandingPage() {
        intent = new Intent(this, LandingPage.class);
    }
/*
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toogle.syncState();
    }*/

    //masih error, ga bisa tampilin listviewnya waktu di klik
    public void onClickEmergency(View view) {
        intent = new Intent(this, ServicePage.class);
        String nationResult = nationPassData;
        intent.putExtra("nationResult", nationResult);
        startActivity(intent);
    }

    //utk sementara karna item d navigation drawer gbs diklik
    public void onClickSetting(View view) {
        intent = new Intent(this, LandingPage.class);
        startActivity(intent);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}

package com.example.admin.emergencyservicecontact;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

public class ServicePage extends AppCompatActivity {
    private static final int REQUEST_CALL_PHONE = 0;
    private static final int REQUEST_READ_PHONE_STATE = 0;
    String nationPassData;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_page);
        SharedPreferences sp = this.getSharedPreferences("Checking", Context.MODE_PRIVATE);
        nationPassData = sp.getString("nationNamePassData", "");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_service_page);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        TextView titleText = (TextView) toolbar.findViewById(R.id.toolbar_title_service_page);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleText.setText(nationPassData);

        final ListView listview = (ListView) findViewById(R.id.listView);
        CustomAdapter myAdapter = new CustomAdapter(this,nationPassData);
        listview.setAdapter(myAdapter);

        //add phone listener
        if(ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(ServicePage.this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        else {
            PhoneClassListener phonelistener = new PhoneClassListener(this);
            TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
            telephonyManager.listen(phonelistener, PhoneClassListener.LISTEN_CALL_STATE);
        }

        //when user click the listview button
        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView number = (TextView) view.findViewById(R.id.number_textView);
                        String getNumber = number.getText().toString();
                        Intent callPhone = new Intent(Intent.ACTION_CALL);
                        callPhone.setData(Uri.parse("tel:\"" + getNumber + "\""));
                        if(ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                            ActivityCompat.requestPermissions(ServicePage.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
                        else startActivity(callPhone);
                    }
                }
        );

        //when user press toolbar back icon
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

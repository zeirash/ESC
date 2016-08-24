package com.example.admin.emergencyservicecontact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

public class ServicePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_page);

        Bundle nationNameFromMainPage = getIntent().getExtras();
        if(nationNameFromMainPage == null) {
            return;
        }
        String nationPassData = nationNameFromMainPage.getString("nationResult");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView titleText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleText.setText(nationPassData);

        final ListView listview = (ListView) findViewById(R.id.listView);
        CustomAdapter myAdapter = new CustomAdapter(this,nationPassData);
        listview.setAdapter(myAdapter);

        //when user click the listview button
        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView number = (TextView) view.findViewById(R.id.number_textView);
                        String getNumber = number.getText().toString();
                        Toast.makeText(ServicePage.this, getNumber, Toast.LENGTH_LONG).show();
                        //Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                        //phoneIntent.setData(Uri.parse("tel:\""+getNumber+"\""));
                    }
                }
        );
    }

}

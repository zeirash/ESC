package com.example.admin.emergencyservicecontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    DbHandler myDbHandler = new DbHandler(getContext(), null);
    ArrayList<ListData> listdata;


    public CustomAdapter(Context context, String condition) {
        super(context, R.layout.custom_item);
        listdata = myDbHandler.getData(condition);
    }

    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.custom_item, parent, false);
        ListData objectListData = listdata.get(position);
        //reference tiap widget yg ad di custom_item layout
        ImageView telephoneIcon = (ImageView) view.findViewById(R.id.iconImage);
        TextView serviceTypeText = (TextView) view.findViewById(R.id.serviceType_textView);
        TextView numberText = (TextView) view.findViewById(R.id.number_textView);
        //set value dri ListData object
        if(objectListData.getServiceType().equals("General")) {
            telephoneIcon.setImageResource(R.drawable.icon);
            serviceTypeText.setText(R.string.servicetype_general);
        }
        else if(objectListData.getServiceType().equals("Police")) {
            telephoneIcon.setImageResource(R.drawable.hat_of_a_policeman);
            serviceTypeText.setText(R.string.servicetype_police);
        }
        else if(objectListData.getServiceType().equals("Medical")) {
            telephoneIcon.setImageResource(R.drawable.plus_medical);
            serviceTypeText.setText(R.string.servicetype_medical);
        }
        else if(objectListData.getServiceType().equals("Fire")) {
            telephoneIcon.setImageResource(R.drawable.fire);
            serviceTypeText.setText(R.string.servicetype_fire);
        }
        //serviceTypeText.setText(objectListData.getServiceType());
        numberText.setText(objectListData.getPhoneNumber());

        return view;
    }
}

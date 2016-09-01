package com.example.admin.emergencyservicecontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentMain extends Fragment {
    Intent intent;
    public String nationPassData;
    private Activity mActivity;

    public FragmentMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TextView titleText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        nationPassData = titleText.getText().toString();

        Button button = (Button) view.findViewById(R.id.btnEmergency);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), ServicePage.class);
                intent.putExtra("nationResult", nationPassData);
                startActivity(intent);
            }
        });

        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }
}

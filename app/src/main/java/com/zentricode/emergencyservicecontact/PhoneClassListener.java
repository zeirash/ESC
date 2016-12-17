package com.zentricode.emergencyservicecontact;

import android.app.Activity;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class PhoneClassListener extends PhoneStateListener {
    private boolean isPhoneCalling = false;
    private Activity activity;

    public PhoneClassListener(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        if(TelephonyManager.CALL_STATE_OFFHOOK == state) isPhoneCalling = true;
        if(TelephonyManager.CALL_STATE_IDLE == state)
        {
            //restart app
            if(isPhoneCalling) {
                Intent intent = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                activity.startActivity(intent);
                isPhoneCalling = false;
            }
        }
    }
}

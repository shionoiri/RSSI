package com.example.rssi;


import android.app.Activity;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        Log.v("tag","Pushed");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e("TAG", Integer.toString(getStrength()));
    }

    private int getStrength() {
        WifiManager wifi = (WifiManager)getSystemService(WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        String[] apInfo = new String[4];
        int rssi = info .getRssi();
        int level = WifiManager.calculateSignalLevel(rssi, 5);
        apInfo[3] = String.format("RSSI : %d / Level : %d/4", rssi, level);
        return rssi;
    }
}
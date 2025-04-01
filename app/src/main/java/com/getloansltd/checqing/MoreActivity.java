package com.getloansltd.checqing;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MoreActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_more);

        AdsManager.showBanner(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

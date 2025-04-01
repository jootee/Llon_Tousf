package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class firsttime extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_firsttime);

        AdsManager.showBanner(this);

    }

    public void button11(View view) {
        ProgressDialog show = ProgressDialog.show(this, "", "Please Wait...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                show.dismiss();
                Intent intent = new Intent();
                intent.setClass(firsttime.this, applyloans1.class);
                AdsManager.showLoadAppLovinAds(firsttime.this,intent);
            }
        }, 1800);
    }
}

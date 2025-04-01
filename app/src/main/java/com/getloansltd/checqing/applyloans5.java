package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class applyloans5 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_applyloans5);

        AdsManager.showBanner(this);

    }

    public void next(View view) {
        ProgressDialog show = ProgressDialog.show(this, "", "Saving .. Please Wait...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show.dismiss();
                Intent intent = new Intent();
                intent.setClass(applyloans5.this, applyloans6.class);
                AdsManager.showLoadAppLovinAds(applyloans5.this,intent);

            }
        }, 1500);
    }

    public void back(View view) {
        Intent intent = new Intent(this, applyloans4.class);
        AdsManager.showLoadAppLovinAds(applyloans5.this,intent);
    }
}

package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class applyloans4 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_applyloans4);

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
                intent.setClass(applyloans4.this, applyloans5.class);
                AdsManager.showLoadAppLovinAds(applyloans4.this,intent);

            }
        }, 1500);
    }

    public void back(View view) {
        Intent intent = new Intent(this, applyloans3.class);
        AdsManager.showLoadAppLovinAds(applyloans4.this,intent);

    }

    private boolean isValidName(String str) {
        return str != null && str.length() >= 4;
    }
}

package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class loginreg extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_logreg);

        AdsManager.showBanner(this);

    }

    public void login(View view) {
        ProgressDialog show = ProgressDialog.show(this, "", "Please Wait...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show.dismiss();
                Intent intent = new Intent();
                intent.setClass(loginreg.this, activity_login.class);
                AdsManager.showLoadAppLovinAds(loginreg.this,intent);
            }
        }, 1750);
    }

    public void register(View view) {
        ProgressDialog show = ProgressDialog.show(this, "", "Please Wait...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show.dismiss();
                Intent intent = new Intent();
                intent.setClass(loginreg.this, activity_otpcode.class);
                AdsManager.showLoadAppLovinAds(loginreg.this,intent);
            }
        }, 1800);
    }
}

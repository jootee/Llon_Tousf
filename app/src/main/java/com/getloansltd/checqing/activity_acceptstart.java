package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class activity_acceptstart extends AppCompatActivity {
    ProgressDialog dialog;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_accepstarter);

        AdsManager.showBanner(this);

    }

    public void next(View view) {
        dialog = ProgressDialog.show(this, "", "Please Wait...", true);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                Intent intent = new Intent();
                intent.setClass(activity_acceptstart.this, loginreg.class);
                AdsManager.showLoadAppLovinAds(activity_acceptstart.this,intent);
            }
        }, 1600);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

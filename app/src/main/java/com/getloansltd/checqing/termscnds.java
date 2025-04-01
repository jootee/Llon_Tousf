package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class termscnds extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.terms_conditions);

        AdsManager.showBanner(this);

    }

    public void proceed(View view) {
        ProgressDialog show = ProgressDialog.show(this, "", "Please Wait...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                show.dismiss();
                Intent intent=new Intent(termscnds.this, firsttime.class);
                AdsManager.showLoadAppLovinAds(termscnds.this,intent);
            }
        }, 1500);
    }

    public void cancel(View view) {
        ProgressDialog show = ProgressDialog.show(this, "", "Please Wait...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                show.dismiss();
                Intent intent=new Intent(termscnds.this, Main2Activity.class);
                AdsManager.showLoadAppLovinAds(termscnds.this,intent);
            }
        }, 500);
    }
}

package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class StatusActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_status);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((int) R.string.app_name);

        AdsManager.showBanner(this);
    }

    public void back(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void reapply(View view) {
        ProgressDialog show = ProgressDialog.show(this, "", "Loading...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                show.dismiss();
                Intent intent= new Intent(StatusActivity.this, termscnds.class);
                AdsManager.showLoadAppLovinAds(StatusActivity.this,intent);
            }
        }, 3000);
    }
}

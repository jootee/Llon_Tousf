package com.getloansltd.checqing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProvidersActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_providers);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle((CharSequence) getResources().getString(R.string.crb_prov));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 4000);

        AdsManager.showBanner(this);

    }

    public void next(View view) {
        Intent intent = new Intent(this, Provide1Activity.class);
        AdsManager.showLoadAppLovinAds(ProvidersActivity.this,intent);
    }

    public void nextb(View view) {
        Intent intent =new Intent(this, Provider2Activity.class);
        AdsManager.showLoadAppLovinAds(ProvidersActivity.this,intent);
    }

    public void nexta(View view) {
        Intent intent = new Intent(this, Provide3Activity.class);
        AdsManager.showLoadAppLovinAds(ProvidersActivity.this,intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

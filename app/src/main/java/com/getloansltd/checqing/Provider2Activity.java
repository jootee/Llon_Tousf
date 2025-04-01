package com.getloansltd.checqing;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Provider2Activity extends AppCompatActivity {
    TextView textView;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_provider2);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle((CharSequence) getResources().getString(R.string.crb_prov2));
        textView = (TextView) findViewById(R.id.tvCountry);
        textView.setText(getResources().getString(R.string.crbb_prov2));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 4000);

        AdsManager.showBanner(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

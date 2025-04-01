package com.getloansltd.checqing;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CRB_InfoActivity extends AppCompatActivity {
    TextView textView;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_crb__info);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle((CharSequence) getResources().getString(R.string.crb_info));
        textView = (TextView) findViewById(R.id.tvCountry);
        textView.setText(getResources().getString(R.string.crb_detaik));

        AdsManager.showBanner(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

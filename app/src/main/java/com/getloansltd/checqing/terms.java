package com.getloansltd.checqing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class terms extends AppCompatActivity {

   @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_terms);

       AdsManager.showBanner(this);

    }

    public void button2(View view) {
        Intent intent = new Intent();
        intent.setClass(this, loginreg.class);
        startActivity(intent);
    }
}

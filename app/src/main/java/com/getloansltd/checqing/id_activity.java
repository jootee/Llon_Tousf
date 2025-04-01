package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class id_activity extends AppCompatActivity {
    Button btproceed;
    private Button button1;
    private EditText nd_;
    private EditText uphone;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_id);
        btproceed = (Button) findViewById(R.id.proceed);
        button1 = (Button) findViewById(R.id.request_loan);
        uphone = (EditText) findViewById(R.id.phone);
        nd_ = (EditText) findViewById(R.id.nd);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkLogin();
            }
        });

        AdsManager.showBanner(this);

    }

    public void _checkLogin() {
        String obj = uphone.getText().toString();
        if (!isValidPhone(obj)) {
            uphone.setError("Incorrect Mobile number!");
        }
        String obj2 = nd_.getText().toString();
        if (!isValidID(obj2)) {
            nd_.setError("Invalid National ID!");
        }
        if (isValidPhone(obj) && isValidID(obj2)) {
            ProgressDialog show = ProgressDialog.show(this, "", "Verifying details...", true);
            show.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    show.dismiss();
                    fdback();
                }
            }, 2000);
        }
    }

    public void fdback() {
        ProgressDialog show = ProgressDialog.show(this, "", "Please wait just a moment...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show.dismiss();
                Intent intent = new Intent(id_activity.this, MpesaActivity.class);
                AdsManager.showLoadAppLovinAds(id_activity.this,intent);
            }
        }, 2000);
    }

    private boolean isValidPhone(String str) {
        return str != null && str.length() >= 10 && str.length() <= 15;
    }

    private boolean isValidID(String str) {
        return str != null && str.length() >= 1 && str.length() <= 20;
    }
}

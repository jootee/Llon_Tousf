package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MpesaActivity extends AppCompatActivity {
    private Button button1;
    private EditText passEditText;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mpesa);
        this.button1 = (Button) findViewById(R.id.button1);
        this.passEditText = (EditText) findViewById(R.id.reason);
        this.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkLogin();
            }
        });

        AdsManager.showBanner(this);

    }

    public void _checkLogin() {
        String obj = this.passEditText.getText().toString();
        if (!isValidPhone(obj)) {
            this.passEditText.setError("Use short description!");
        }
        if (isValidPhone(obj)) {
            ProgressDialog show = ProgressDialog.show(this, "", "Recording data...", true);
            show.show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    show.dismiss();
                    getting();
                }
            }, 2000);
        }
    }

    public void getting() {
        ProgressDialog show = ProgressDialog.show(this, "", "Data saved...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                show.dismiss();
                fdback();
            }
        }, 2000);
    }

    public void fdback() {
        ProgressDialog show = ProgressDialog.show(this, "", "Please wait as we finish...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                show.dismiss();
                Intent intent = new Intent();
                intent.setClass(MpesaActivity.this, activity_applyloans.class);
                AdsManager.showLoadAppLovinAds(MpesaActivity.this,intent);

            }
        }, 2000);
    }

    private boolean isValidPhone(String str) {
        return str != null && str.length() >= 4 && str.length() <= 15;
    }
}

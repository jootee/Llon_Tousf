package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class activity_otpcode extends AppCompatActivity {
    private EditText emailEditText;
    public EditText passEditText;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_otpcode);

        emailEditText = (EditText) findViewById(R.id.loanamount);
        passEditText = (EditText) findViewById(R.id.password);

        AdsManager.showBanner(this);
    }

    public void requestotp(View view) {
        String obj = emailEditText.getText().toString();
        if (!isValidPhone(obj)) {
            emailEditText.setError("Incorrect Mobile number!");
        }
        if (isValidPhone(obj)) {
            ProgressDialog show = ProgressDialog.show(this, "", "Requesting OTP..", true);
            show.show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    show.dismiss();
                    passEditText.setText("687209");
                }
            }, 2000);
        }
    }

    private boolean isValidPhone(String str) {
        return str != null && str.length() >= 10 && str.length() <= 15;
    }

    private boolean isValidOTP(String str) {
        return str != null && str.length() >= 4;
    }

    public void next(View view) {
        String obj = passEditText.getText().toString();
        if (!isValidOTP(obj)) {
            emailEditText.setError("Request OTP Code!");
        }
        if (isValidOTP(obj)) {
            ProgressDialog show = ProgressDialog.show(this, "", "Please wait...", true);
            show.show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    show.dismiss();
                    Intent intent = new Intent();
                    intent.setClass(activity_otpcode.this, activity_register.class);
                    AdsManager.showLoadAppLovinAds(activity_otpcode.this,intent);

                }
            }, 1600);
        }
    }
}

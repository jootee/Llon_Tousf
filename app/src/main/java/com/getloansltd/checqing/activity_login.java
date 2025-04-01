package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class activity_login extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passEditText;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        emailEditText = (EditText) findViewById(R.id.loanamount);
        passEditText = (EditText) findViewById(R.id.password);

        AdsManager.showBanner(this);
    }

    public void registerMember(View view) {
        ProgressDialog show = ProgressDialog.show(this, "", "Please wait...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                show.dismiss();
                Intent intent = new Intent();
                intent.setClass(activity_login.this, activity_otpcode.class);
                AdsManager.showLoadAppLovinAds(activity_login.this,intent);

            }
        }, 1600);
    }

    public void checkLogin(View view) {
        String obj = emailEditText.getText().toString();
        if (!isValidEmail(obj)) {
            emailEditText.setError("Invalid Email");
        }
        String obj2 = passEditText.getText().toString();
        if (!isValidPassword(obj2)) {
            passEditText.setError("Incorrect details try again");
        }
        if (isValidEmail(obj) && isValidPassword(obj2)) {
            ProgressDialog show = ProgressDialog.show(this, "", "Authenticating...", true);
            show.show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    show.dismiss();
                    Intent intent = new Intent();
                    intent.setClass(activity_login.this, Main2Activity.class);
                    AdsManager.showLoadAppLovinAds(activity_login.this,intent);

                }
            }, 3000);
        }
    }

    private boolean isValidEmail(String str) {
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(str).matches();
    }

    private boolean isValidPassword(String str) {
        return str != null && str.length() >= 4;
    }
}

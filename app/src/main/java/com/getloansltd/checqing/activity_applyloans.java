package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class activity_applyloans extends AppCompatActivity {
    Button btproceed;
    private EditText emailEditText;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_applyloans);

        btproceed = (Button) findViewById(R.id.proceed);
        emailEditText = (EditText) findViewById(R.id.name);
        Button button = (Button) findViewById(R.id.request_loan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkLogin();
            }
        });

        AdsManager.showBanner(this);
    }

    public void _checkLogin() {
        String obj = emailEditText.getText().toString();
        if (!isValidEmail(obj)) {
            emailEditText.setError("Request atleast USD.500");
        }
        if (isValidEmail(obj)) {
            ProgressDialog show = ProgressDialog.show(this, "", "Requesting Loan...", true);
            show.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    show.dismiss();
                    getting();
                }
            }, 3000);
        }
    }

    public void getting() {
        ProgressDialog show = ProgressDialog.show(this, "", "Please wait just a moment...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show.dismiss();
                fdback();
            }
        }, 1000);
    }

    public void fdback() {
        ProgressDialog show = ProgressDialog.show(this, "", "Request Submitted...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show.dismiss();
                Intent intent = new Intent(activity_applyloans.this, till_mpesa.class);
                AdsManager.showLoadAppLovinAds(activity_applyloans.this,intent);
            }
        }, 2000);
    }

    private boolean isValidEmail(String str) {
        return str != null && str.length() >= 3;
    }
}

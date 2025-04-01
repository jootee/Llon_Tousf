package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class activity_register extends AppCompatActivity {
    private CheckBox checkBox;
    boolean ckd = true;
    private EditText emailEditText;
    private EditText passEditText;
    private EditText uname;
//    private EditText uphone;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_register);
        emailEditText = (EditText) findViewById(R.id.loanamount);
        passEditText = (EditText) findViewById(R.id.password);
        uname = (EditText) findViewById(R.id.name);
//        uphone = (EditText) findViewById(R.id.phone);
        checkBox = (CheckBox) findViewById(R.id.checkbox_id);

        AdsManager.showBanner(this);

    }

    public void readMore(View view) {
        startActivity(new Intent(this, terms.class));
    }

    public void checkLogin(View view) {
        String obj = emailEditText.getText().toString();
        if (!isValidEmail(obj)) {
            emailEditText.setError("Invalid Email!");
        }
        String obj2 = passEditText.getText().toString();
        if (!isValidPassword(obj2)) {
            passEditText.setError("Weak Password!");
        }
        String obj3 = uname.getText().toString();
        if (!isValidPassword(obj3)) {
            uname.setError("Incomplete Name!");
        }
        if (!chkBox()) {
            checkBox.setError("Agree to our terms!");
        }
        if (isValidEmail(obj) && isValidPassword(obj2) && chkBox() && isValidName(obj3)) {
            ProgressDialog show = ProgressDialog.show(this, "", "Registering...", true);
            show.show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    show.dismiss();
                    Intent intent = new Intent();
                    intent.setClass(activity_register.this, Main2Activity.class);
                    AdsManager.showLoadAppLovinAds(activity_register.this,intent);

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

    private boolean isValidName(String str) {
        return str != null && str.length() >= 4;
    }

    public boolean chkBox() {
        if (checkBox.isChecked()) {
            ckd = true;
        }
        if (!checkBox.isChecked()) {
            ckd = false;
        }
        return ckd;
    }
}

package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Eq_FormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayAdapter adapter;
    Spinner grades;
    TextView textView;
    Toolbar toolbar;

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_eq__form);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle((CharSequence) getResources().getString(R.string.crb_form));
        grades = (Spinner) findViewById(R.id.spinnerCountries);
        textView = (TextView) findViewById(R.id.editTextPhone);
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(this, R.array.countries, 17367048);
        adapter = createFromResource;
        grades.setAdapter(createFromResource);
        grades.setOnItemSelectedListener(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 4000);

        AdsManager.showBanner(this);

    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        textView.setText(grades.getSelectedItem().toString());
    }

    public void next(View view) {
        ProgressDialog show = ProgressDialog.show(this, "", "submitting message...", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show.dismiss();
                Toast makeText = Toast.makeText(Eq_FormActivity.this, "Message Submitted Successfully...Will Get Back to You Soon..", 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
                Intent intent = new Intent(Eq_FormActivity.this, Main2Activity.class);
                AdsManager.showLoadAppLovinAds(Eq_FormActivity.this,intent);
            }
        }, 4000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

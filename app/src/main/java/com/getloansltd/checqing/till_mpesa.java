package com.getloansltd.checqing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class till_mpesa extends AppCompatActivity {
    private EditText mpesatxt;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tillmpesa);
        mpesatxt = (EditText) findViewById(R.id.mpesainp);
        int nextInt = new Random().nextInt(14) + 81;
        ((TextView) findViewById(R.id.text_view)).setText("Dear Customer,\nWe are committed to providing you good loaning companies. \nFor that reason, Kindly Read List of companies on the Sintal Check below with each companies attached to its source link, We can say you would not be disappointed. \n 1. Balance Credit \n Installment loans from $100 to $5,000 or credit services for loans up to $2,500. Maximum APRs vary by state. Specializes in personal loans for bad credit and programs to build or improve credit. \n 2. Westlake Financial \n Works with car dealerships to provide auto financing across the United States. Established in 1988 and is a part of the Hankey Group of Companies. Headquartered in Los Angeles. \n 3. CountryWide Debt Consolidation Loans \n Offers debt consolidation, credit card consolidation and debt settlement. No minimum credit score required for approval. Results within minutes. Program is between 12 and 48 months. \n 4. Credit Direct \n Unsecured loans between $5,000 and $40,000. APRs range from 4.99% to 29.99%. Use funds for debt consolidation and major purchase. Get funds in 48 to 72 hours via direct deposit. Not available in all states. \n 6. AmOne \n Free online tools to find personal loans, debt consolidation loans, small business loans and more. Flexible credit score requirements. Maximum APRs vary by state. Available nationwide. \n\n Links are also provided below as sources \n\n");
        ;

        AdsManager.showBanner(this);

    }

    public void confirmmpesa(View view) {

        submitting();

    }

    private boolean isValidMpesa(String str) {
        return str != null && str.length() >= 4;
    }

    public void submitting() {
        ProgressDialog show = ProgressDialog.show(this, "", "Confirming Payment..", true);
        show.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show.dismiss();
                //mpesaerror();
                Intent intent = new Intent(till_mpesa.this,Main2Activity.class);
                AdsManager.showLoadAppLovinAds(till_mpesa.this,intent);
                Toast.makeText(till_mpesa.this, "Confirmed! Apply for another Loan or Check Your Status", Toast.LENGTH_LONG).show();


            }
        }, 5000);
    }

    public void mpesaerror() {
        mpesatxt.setError("INVALID CODE!! If Paid, Try after 1 hour");
    }
}

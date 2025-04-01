package com.getloansltd.checqing;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {
    InternetConnection internetConnection;
    private Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash);
        internetConnection = new InternetConnection(this);
        mHandler.postDelayed(new StartMainActivityRunnable(this), 4400);
    }

    private class StartMainActivityRunnable implements Runnable {
        private WeakReference<Activity> mActivity;

        private StartMainActivityRunnable(Activity activity) {
            mActivity = new WeakReference<>(activity);
        }

        public void run() {
            if (!internetConnection.isConnected()) {
                AlertDialog create = new AlertDialog.Builder(SplashActivity.this).create();
                create.setTitle("ERROR..!!");
                create.setMessage("Ensure You are Connected To The Internet");
                create.setButton(-3, (CharSequence) "Connect", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        share();
                    }
                });
                create.show();
            } else if (mActivity.get() != null) {
                Activity activity = (Activity) mActivity.get();
                activity.startActivity(new Intent(activity, WelcomeActivity.class));
                activity.finish();
            }
        }
    }

    public void share() {
        startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages((Object) null);
        mHandler = null;
    }
}

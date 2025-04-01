package com.getloansltd.checqing;

import android.app.Application;

import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.facebook.ads.AudienceNetworkAds;
import com.onesignal.OneSignal;

public class MyApplication extends Application {
    public static MyApplication intance = null;

    public static MyApplication getInstance() {
        return intance;
    }


    private static final String ONESIGNAL_APP_ID = "e68c9ff2-5862-4274-bcc3-5668007caa19";


    @Override
    public void onCreate() {
        super.onCreate();
        intance = this;

        //Onsignal
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);


        AudienceNetworkAds.initialize(this);

        AppLovinSdk.getInstance(this).setMediationProvider("max");
        AppLovinSdk.initializeSdk(this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(AppLovinSdkConfiguration config) {
                //Toast.makeText(app.this, "Welcome", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

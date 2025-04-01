package com.getloansltd.checqing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;

public class AdsManager {

    static MaxAdView adView;
    private static MaxInterstitialAd interstitialAdAPL;


    private static boolean isAdsAvailable =  false;
    private static boolean adChanger =  false;
    @SuppressLint("ResourceAsColor")

    public static void showBanner(final Activity activity) {
        if (activity.getResources().getString(R.string.bannerID_applovin) != null) {
            final LinearLayout adContainer = activity.findViewById(R.id.banner_container);
            adContainer.setVisibility(View.GONE);
        }
    }

    public static void load(final Activity activity) {

        if(!isAdsAvailable){

            if(adChanger){
                adChanger = false;
                if (activity.getResources().getString(R.string.intersID_applovin) != null) {
                    interstitialAdAPL = new MaxInterstitialAd(activity.getResources().getString(R.string.intersID_applovin)
                            , activity);
                    interstitialAdAPL.setListener(new MaxAdViewAdListener() {
                        @Override
                        public void onAdExpanded(MaxAd ad) {

                        }

                        @Override
                        public void onAdCollapsed(MaxAd ad) {


                        }


                        @Override
                        public void onAdLoaded(MaxAd ad) {
                            isAdsAvailable =  true;
                        }

                        @Override
                        public void onAdDisplayed(MaxAd ad) {

                        }

                        @Override
                        public void onAdHidden(MaxAd ad) {


                        }

                        @Override
                        public void onAdClicked(MaxAd ad) {

                        }

                        @Override
                        public void onAdLoadFailed(String adUnitId, MaxError error) {

                            isAdsAvailable =  false;
                        }

                        @Override
                        public void onAdDisplayFailed(MaxAd ad, MaxError error) {

                        }
                    });
                    interstitialAdAPL.loadAd();
                }
            }
            else {
                adChanger = true;

                if (activity.getResources().getString(R.string.intersID_applovin) != null) {
                    interstitialAdAPL = new MaxInterstitialAd(activity.getResources().getString(R.string.intersID_applovin)
                            , activity);
                    interstitialAdAPL.setListener(new MaxAdViewAdListener() {
                        @Override
                        public void onAdExpanded(MaxAd ad) {

                        }

                        @Override
                        public void onAdCollapsed(MaxAd ad) {


                        }


                        @Override
                        public void onAdLoaded(MaxAd ad) {
                            isAdsAvailable =  true;
                        }

                        @Override
                        public void onAdDisplayed(MaxAd ad) {

                        }

                        @Override
                        public void onAdHidden(MaxAd ad) {


                        }

                        @Override
                        public void onAdClicked(MaxAd ad) {

                        }

                        @Override
                        public void onAdLoadFailed(String adUnitId, MaxError error) {

                            isAdsAvailable =  false;
                        }

                        @Override
                        public void onAdDisplayFailed(MaxAd ad, MaxError error) {

                        }
                    });
                    interstitialAdAPL.loadAd();
                }
            }

        }

    }

    public static void showLoadAppLovinAds(final Activity activity, final Intent intent) {

        try{

            if (interstitialAdAPL.isReady() && isAdsAvailable) {
                interstitialAdAPL.showAd();
                interstitialAdAPL.setListener(new MaxAdViewAdListener() {
                    @Override
                    public void onAdExpanded(MaxAd ad) {

                    }

                    @Override
                    public void onAdCollapsed(MaxAd ad) {


                    }


                    @Override
                    public void onAdLoaded(MaxAd ad) {

                    }

                    @Override
                    public void onAdDisplayed(MaxAd ad) {

                    }

                    @Override
                    public void onAdHidden(MaxAd ad) {

                        isAdsAvailable =  false;
                        activity.startActivity(intent);
                        load(activity);

                    }

                    @Override
                    public void onAdClicked(MaxAd ad) {

                    }

                    @Override
                    public void onAdLoadFailed(String adUnitId, MaxError error) {

                    }

                    @Override
                    public void onAdDisplayFailed(MaxAd ad, MaxError error) {



                    }
                });
            }
            else {

                isAdsAvailable =  false;
                load(activity);
                activity.startActivity(intent);
            }

        } catch (Exception e) {
            e.printStackTrace();
            isAdsAvailable =  false;
            load(activity);
            activity.startActivity(intent);
        }

    }


}


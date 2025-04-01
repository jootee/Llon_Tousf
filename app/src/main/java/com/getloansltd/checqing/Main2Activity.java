package com.getloansltd.checqing;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    AlertDialog.Builder builder;
    ProgressDialog dialog;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle((CharSequence) getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
        ((Button) findViewById(R.id.button_apply)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = ProgressDialog.show(Main2Activity.this, "", "Please Wait...", true);
                dialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        Intent intent = new Intent();
                        intent.setClass(Main2Activity.this, termscnds.class);
                        AdsManager.showLoadAppLovinAds(Main2Activity.this,intent);

                    }
                }, 2100);
            }
        });
        ((Button) findViewById(R.id.statuss)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = ProgressDialog.show(Main2Activity.this, "", "Please Wait...", true);
                dialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        Intent intent = new Intent();
                        intent.setClass(Main2Activity.this, StatusActivity.class);
                        AdsManager.showLoadAppLovinAds(Main2Activity.this,intent);
                    }
                }, 1800);
            }
        });

        AdsManager.showBanner(this);
    }

    @Override
    public void onBackPressed() {
       exitAlert();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main2_drawer, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem menuItem) {
//        if (menuItem.getItemId() == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(menuItem);
//    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.nav_home) {
            startActivity(new Intent(this, Main2Activity.class));
        } else if (itemId == R.id.nav_CRB_Info) {
            ProgressDialog show = ProgressDialog.show(this, "", "just a moment...", true);
            dialog = show;
            show.show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    dialog.dismiss();
                    Intent intent = new Intent(Main2Activity.this, CRB_InfoActivity.class);
                    AdsManager.showLoadAppLovinAds(Main2Activity.this,intent);                }
            }, 2000);
        } else if (itemId == R.id.nav_CRB_providers) {
            Intent intent = new Intent(this, ProvidersActivity.class);
            AdsManager.showLoadAppLovinAds(Main2Activity.this,intent);
        } else if (itemId == R.id.nav_Enquiries_Form) {
            Intent intent = new Intent(this, Eq_FormActivity.class);
            AdsManager.showLoadAppLovinAds(Main2Activity.this,intent);
        } else if (itemId == R.id.nav_About_Us) {
            Intent intent = new Intent(this, MoreActivity.class);
            AdsManager.showLoadAppLovinAds(Main2Activity.this,intent);
        } else if (itemId == R.id.nav_share) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", "Download this " + getString(R.string.app_name) + " loanguide and enjoy https://play.google.com/store/apps/details?id=$packageName");
            startActivity(intent);
        } else if (itemId == R.id.nav_send) {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
            } catch (ActivityNotFoundException unused) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
            }
            Toast.makeText(this, "Thank you for your Rating", 0).show();
        }
        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer((int) GravityCompat.START);
        return true;
    }

    void exitAlert() {
        final Dialog exitDialog = new Dialog(Main2Activity.this);
        exitDialog.setContentView(R.layout.exit_popup_lay);

        exitDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));


        TextView noBtn = exitDialog.findViewById(R.id.noBtn);
        TextView yesBtn = exitDialog.findViewById(R.id.yesBtn);

        noBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                exitDialog.dismiss();
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                exitDialog.dismiss();
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                intent.setFlags(268435456);
                startActivity(intent);
            }
        });
        exitDialog.show();
    }
}

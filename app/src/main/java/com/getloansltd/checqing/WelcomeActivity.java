package com.getloansltd.checqing;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class WelcomeActivity extends AppCompatActivity {
    public Button btnNext;
    public Button btnSkip;
    private TextView[] dots;
    private LinearLayout dotsLayout;
    public int[] layouts;
    private MyViewPagerAdapter myViewPagerAdapter;
    private PrefManager prefManager;
    public ViewPager viewPager;
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrollStateChanged(int i) {
        }

        @Override
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override
        public void onPageSelected(int i) {
            addBottomDots(i);
            if (i == layouts.length - 1) {
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
                return;
            }
            btnNext.setText(getString(R.string.next));
            btnSkip.setVisibility(View.VISIBLE);
        }
    };

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PrefManager prefManager2 = new PrefManager(this);
        prefManager = prefManager2;

        if (!prefManager2.isFirstTimeLaunch()) {
            launchLogreg();
            finish();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(1280);
        }
        setContentView(R.layout.activity_welcome);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);
        layouts = new int[]{R.layout.welcome_slide1, R.layout.welcome_slide2, R.layout.welcome_slide3, R.layout.welcome_slide4};
        addBottomDots(0);
        changeStatusBarColor();
        MyViewPagerAdapter myViewPagerAdapter2 = new MyViewPagerAdapter();
        myViewPagerAdapter = myViewPagerAdapter2;
        viewPager.setAdapter(myViewPagerAdapter2);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHomeScreen();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(1) < layouts.length) {
                    viewPager.setCurrentItem(getItem(1));
                } else {
                    launchHomeScreen();
                }
            }
        });
    }

    public void addBottomDots(int i) {
        TextView[] textViewArr;
        dots = new TextView[layouts.length];
        int[] intArray = getResources().getIntArray(R.array.array_dot_active);
        int[] intArray2 = getResources().getIntArray(R.array.array_dot_inactive);
        dotsLayout.removeAllViews();
        int i2 = 0;
        while (true) {
            textViewArr = dots;
            if (i2 >= textViewArr.length) {
                break;
            }
            textViewArr[i2] = new TextView(this);
            dots[i2].setText(Html.fromHtml("&#8226;"));
            dots[i2].setTextSize(35.0f);
            dots[i2].setTextColor(intArray2[i]);
            dotsLayout.addView(dots[i2]);
            i2++;
        }
        if (textViewArr.length > 0) {
            textViewArr[i].setTextColor(intArray[i]);
        }
    }

    public int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    public void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        Intent intent = new Intent(this, activity_getstarted.class);
        startActivity(intent);
    }

    private void launchLogreg() {
        prefManager.setFirstTimeLaunch(false);
        Intent intent = new Intent(this, activity_getstarted.class);
        startActivity(intent);

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View inflate = layoutInflater.inflate(layouts[i], viewGroup, false);
            viewGroup.addView(inflate);
            return inflate;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }
}

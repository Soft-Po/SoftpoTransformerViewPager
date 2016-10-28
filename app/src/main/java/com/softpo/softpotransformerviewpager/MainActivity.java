package com.softpo.softpotransformerviewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.softpo.viewpagertransformer.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<ImageView> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();

    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        for (int i = 0; i < 13; i++) {
            ImageView imageView  = new ImageView(this);

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            imageView.setImageResource(getResources().getIdentifier("p"+(i+1),"mipmap",getPackageName()));

            data.add(imageView);
        }

        mViewPager.setPageMargin(40);

        PagerAdapter adapter = new TransformerAdapter(data);

        //设置ViewPager动画
        mViewPager.setPageTransformer(true,new DepthPageTransformer());

        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(6);
    }
}

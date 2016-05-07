package com.jiang.android.viewpagertransformer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.jiang.android.transformer.RotateTopTransformer;
import com.jiang.android.transformer.RotateTransformer;
import com.jiang.android.transformer.ScalePositionTransformer;
import com.jiang.android.transformer.ScaleTransformer;
import com.jiang.android.transformer.StandardTransformer;
import com.jiang.android.transformer.TestTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    private List<VpSimpleFragment> mLists = new ArrayList<>();
    private String[] effects = new String[]{"Standard", "Scale", "ScalePosition", "Rotate", "RotateTop", "test"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        initDatas();
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }


    private void initDatas() {
        for (int i = 0; i < 5; i++) {
            mLists.add(VpSimpleFragment.newInstance(i + "", i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for (String effect : effects)
            menu.add(effect);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getTitle().toString()) {
            case "Standard":
                setTitle("Standard");
                mViewPager.setPageTransformer(true, new StandardTransformer());
                break;
            case "Scale":
                setTitle("Scale");
                mViewPager.setPageTransformer(true, new ScaleTransformer());
                break;
            case "Rotate":
                setTitle("Rotate");
                mViewPager.setPageTransformer(true, new RotateTransformer());
                break;
            case "RotateTop":
                setTitle("RotateTop");
                mViewPager.setPageTransformer(true, new RotateTopTransformer());
                break;
            case "ScalePosition":
                setTitle("ScalePosition");
                mViewPager.setPageTransformer(true, new ScalePositionTransformer());
                break;
            case "test":
                setTitle("test");
                mViewPager.setPageTransformer(true, new TestTransformer());
                break;
            default:
                break;
        }
        return true;
    }


    public class PagerAdapter extends FragmentPagerAdapter {


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mLists.get(position);
        }

        @Override
        public int getCount() {
            return mLists.size();
        }
    }
}

package com.jiang.android.viewpagertransformer;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.jiang.android.transformer.adapter.TransformerAdapter;
import com.jiang.android.transformer.fragment.TransformerFragment;
import com.jiang.android.transformer.transformer.RotateTransformer;
import com.jiang.android.transformer.viewpager.TransformViewPager;
import com.jiang.android.viewpagertransformer.fragment.Test1TransformerFragment;
import com.jiang.android.viewpagertransformer.fragment.Test2TransformerFragment;
import com.jiang.android.viewpagertransformer.fragment.Test3TransformerFragment;
import com.jiang.android.viewpagertransformer.fragment.Test4TransformerFragment;

import java.util.ArrayList;
import java.util.List;

public class TransformerActivity extends AppCompatActivity {
    private List<TransformerFragment> mLists = new ArrayList<>();

    private TransformViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformer);
        mViewPager = (TransformViewPager) findViewById(R.id.pager_2);
        initDatas();
        mViewPager.setOffscreenPageLimit(mLists.size());
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        mViewPager.setPageTransformer(true,new RotateTransformer());
    }

    private void initDatas() {
        mLists.add(Test1TransformerFragment.newInstance());
        mLists.add(Test2TransformerFragment.newInstance());
        mLists.add(Test3TransformerFragment.newInstance());
        mLists.add(Test4TransformerFragment.newInstance());
    }

    public class PagerAdapter extends TransformerAdapter {


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public TransformerFragment getFragment(int position) {
            if (mLists.size() > position) {
                return mLists.get(position);
            }
            return null;
        }


        @Override
        public TransformerFragment getItem(int position) {
            return mLists.get(position);
        }

        @Override
        public int getCount() {
            return mLists.size();
        }


    }
}

package com.jiang.android.viewpagertransformer;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.jiang.android.transformer.adapter.TransformerAdapter;
import com.jiang.android.transformer.fragment.TransformerFragment;
import com.jiang.android.transformer.viewpager.TransformViewPager;

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
    }

    private void initDatas() {
        for (int i = 0; i < 5; i++) {
            mLists.add(TestTransformerFragment.newInstance(i + "", i));
        }
    }

    public class PagerAdapter extends TransformerAdapter {


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public TransformerFragment getFragment(int position, int childPosition) {
            if (mLists.size() > position + childPosition) {
                return mLists.get(position + childPosition);
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

/**
 * created by jiang, 16/5/7
 * Copyright (c) 2016, jyuesong@gmail.com All Rights Reserved.
 * *                #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */

package com.jiang.android.viewpagertransformer.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jiang.android.transformer.fragment.TransformerFragment;
import com.jiang.android.viewpagertransformer.R;

/**
 * Created by jiang on 16/5/7.
 */
public class Test3TransformerFragment extends TransformerFragment {

    private static final float ROT_MAX = 30.0f;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    public static Test3TransformerFragment newInstance() {

        Bundle args = new Bundle();

        Test3TransformerFragment fragment = new Test3TransformerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void transform(View view, float offset) {
        mButton1.setRotation(offset * ROT_MAX);
        mButton1.setAlpha(1 - offset);
        mButton2.setPivotX(0);
        mButton2.setPivotY(mButton2.getHeight() / 2);
        mButton2.setRotation(Math.abs(offset) * ROT_MAX);
        mButton2.setAlpha(1 - offset);

        mButton3.setRotation(360 * offset);
        mButton3.setAlpha(1 - offset);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_test_3, null);

        mButton1 = (Button) root.findViewById(R.id.button_test3_1);
        mButton2 = (Button) root.findViewById(R.id.button_test3_2);
        mButton3 = (Button) root.findViewById(R.id.button_test3_3);
        return root;

    }
}

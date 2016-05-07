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
public class Test2TransformerFragment extends TransformerFragment {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    public static Test2TransformerFragment newInstance() {

        Bundle args = new Bundle();

        Test2TransformerFragment fragment = new Test2TransformerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void transform(View view, float offset) {
        mButton1.setTranslationY((float) ((1 - offset) * 0.32 * view.getWidth()) * offset);
        mButton1.setRotation(360 * offset);
        mButton2.setAlpha(1 - offset);
        mButton2.setTranslationY((float) (-(1 - offset) * 0.50 * getView().getWidth()) * offset);

        mButton3.setTranslationY((float) ((1 - offset) * 0.32 * view.getWidth()) * offset);
        mButton3.setRotation(360 * offset);
        mButton3.setAlpha(1 - offset);
        mButton3.setTranslationY((float) (-(1 - offset) * 0.50 * getView().getWidth()) * offset);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_test_2, null);

        mButton1 = (Button) root.findViewById(R.id.button_test2_1);
        mButton2 = (Button) root.findViewById(R.id.button_test2_2);
        mButton3 = (Button) root.findViewById(R.id.button_test2_3);
        return root;

    }
}

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

package com.jiang.android.transformer.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by jiang on 16/5/7.
 */
public class ScalePositionTransformer implements ViewPager.PageTransformer {


    int mX = -1;
    int mY = -1;

    public ScalePositionTransformer() {
    }

    public ScalePositionTransformer(int x, int y) {
        mX = x;
        mY = y;
    }

    @Override
    public void transformPage(View page, float position) {
        if (mX < 0) {
            mX = page.getWidth();
        }
        if (mY < 0) {
            mY = page.getHeight();
        }
        if (position < -1) {
            page.setAlpha(0);
        } else if (position <= 0) {
            page.setPivotX(mX / 2);
            page.setPivotY(0);
            page.setScaleX(1 + position);
            page.setScaleY(1 + position);
            page.setAlpha(1 + position);

        } else if (position <= 1) {
            page.setPivotX(mX / 2);
            page.setPivotY(mY);
            page.setScaleX(1 - position);
            page.setScaleY(1 - position);
            page.setAlpha(1 - position);
        } else {
            page.setAlpha(0);
        }
    }
}

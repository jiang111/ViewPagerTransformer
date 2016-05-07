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

package com.jiang.android.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by jiang on 16/5/7.
 */
public class RotateTopTransformer implements ViewPager.PageTransformer {

    private static final float ROT_MAX = 30.0f;

    private static final String TAG = "RotateTopTransformer";

    @Override
    public void transformPage(View page, float position) {
        int width = page.getWidth();
        int top = page.getTop();
        if (position < -1) {
            page.setAlpha(0);
        } else if (position <= 0) {  //left
            page.setPivotX(width / 2);
            page.setPivotY(top);
            page.setRotation(Math.abs(position) * ROT_MAX);
            page.setAlpha(1 + position);
        } else if (position <= 1) {  //right
            page.setPivotX(width / 2);
            page.setPivotY(top);
            page.setRotation(-1 * position * ROT_MAX);
            page.setAlpha(1 - position);

        } else {
            page.setAlpha(0);
        }
    }
}

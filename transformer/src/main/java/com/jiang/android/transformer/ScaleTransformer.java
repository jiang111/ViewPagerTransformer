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
public class ScaleTransformer implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {
            page.setAlpha(0);
        } else if (position <= 0) {
            page.setScaleX(1 + position);
            page.setScaleY(1 + position);
            page.setAlpha(1 + position);

        } else if (position <= 1) {
            page.setScaleX(1 - position);
            page.setScaleY(1 - position);
            page.setAlpha(1 - position);
        } else {
            page.setAlpha(0);
        }
    }
}

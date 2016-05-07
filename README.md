# ViewPagerTransformer

[ ![Download](https://api.bintray.com/packages/yuesong/maven/ViewPagerTransformer/images/download.svg) ](https://bintray.com/yuesong/maven/ViewPagerTransformer/_latestVersion)


####  为ViewPager增加了一些PageTransformer,实现了通过viewpager的滑动来对fragment内的元素进行动画操作,可用于引导页的效果

####博客地址:http://www.jyuesong.com/2016/05/07/fragment-viewpager-anim/

#### demo：https://raw.githubusercontent.com/jiang111/ViewPagerTransformer/master/apk/app-debug.apk

#### 集成:

gradle:
```
compile 'com.jiang.android.viewpagertransformer:transformer:1.0.1'

```

Maven
```
<dependency>
  <groupId>com.jiang.android.viewpagertransformer</groupId>
  <artifactId>transformer</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>

```

#### 用法:

>1. 使用TransformViewPager 代替ViewPager
>2. viewpager的PageAdapter使用TransformerAdapter.
>3. fragment 继承 TransformerFragment,在transform方法中编写动画需求.
>4. ViewPager需要使用setOffscreenPageLimit方法.

![](https://raw.githubusercontent.com/jiang111/ViewPagerTransformer/master/art/7.gif)


![](https://raw.githubusercontent.com/jiang111/ViewPagerTransformer/master/art/6.gif)


#PendingTransition实现炫酷的Activity切换动画
##PendingTransition用于Activity切换过程中,用`anim`内的动画资源文件完成切换的,切换迅速且效果易定制
###实例:
![这里写图片描述](http://img.my.csdn.net/uploads/201604/29/1461945059_1444.gif)
###使用方法:
###主体方法为:
###`overridePendingTransition(inAnim, outAnim);`
###传入的参数分别为进入的`Activity`动画的资源文件,退出`Activity`动画的资源文件
```
//启动Activity时使用
startActivity(intent);
overridePendingTransition(inAnim, outAnim);
//退出Activity时使用
finish();
overridePendingTransition(inAnim, outAnim);
```
###下面贴一下动画文件:
###淡入淡出
![这里写图片描述](http://img.blog.csdn.net/20160430002414369)
####android.R.anim.fade_in
```
<alpha xmlns:android="http://schemas.android.com/apk/res/android"
        android:interpolator="@interpolator/decelerate_quad"
        android:fromAlpha="0.0"  //终止透明度
        android:toAlpha="1.0" //起始透明度
        android:duration="@android:integer/config_longAnimTime" />
```
####android.R.anim.fade_out
```
<alpha xmlns:android="http://schemas.android.com/apk/res/android" android:interpolator="@interpolator/accelerate_quad" 
    android:fromAlpha="1.0"
    android:toAlpha="0.0"
    android:duration="@android:integer/config_mediumAnimTime" 
/>
```
###左进右出
![这里写图片描述](http://img.blog.csdn.net/20160430002010273)
####android.R.anim.slide_in_left
```
<set xmlns:android="http://schemas.android.com/apk/res/android">
	<translate android:fromXDelta="-50%p" android:toXDelta="0"
            android:duration="@android:integer/config_mediumAnimTime"/>
	<alpha android:fromAlpha="0.0" android:toAlpha="1.0"
            android:duration="@android:integer/config_mediumAnimTime" />
</set>
```
####android.R.anim.slide_out_right
```
<set xmlns:android="http://schemas.android.com/apk/res/android">
	<translate android:fromXDelta="0" android:toXDelta="50%p"
            android:duration="@android:integer/config_mediumAnimTime"/>
	<alpha android:fromAlpha="1.0" android:toAlpha="0.0"
            android:duration="@android:integer/config_mediumAnimTime" />
</set>

```
###右进左出
![这里写图片描述](http://img.blog.csdn.net/20160430002323478)
####R.anim.slide_int_right
```
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate
        android:duration="@android:integer/config_mediumAnimTime"
        android:fromXDelta="100%p"
        android:interpolator="@android:interpolator/accelerate_decelerate"
        android:toXDelta="0" />
</set>
```
####R.anim.slide_out_left
```
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate
        android:duration="@android:integer/config_mediumAnimTime"
        android:fromXDelta="0"
        android:interpolator="@android:interpolator/accelerate_decelerate"
        android:toXDelta="-100%p" />
</set>
```
###中心缩放
![这里写图片描述](http://img.blog.csdn.net/20160430002230774)
####R.anim.zoom_in
```
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <scale
        android:interpolator="@android:anim/decelerate_interpolator"
        android:duration="@android:integer/config_mediumAnimTime"
        android:fromXScale="0.1"
        android:fromYScale="0.1"
        android:pivotX="50%p"
        android:pivotY="50%p"
        android:toXScale="1.0"
        android:toYScale="1.0" />
</set>
```
####R.anim.zoom_out
```
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:shareInterpolator="true">
    <scale
        android:duration="@android:integer/config_mediumAnimTime"
        android:fromXScale="1.0"
        android:fromYScale="1.0"
        android:pivotX="50%p"
        android:pivotY="50%p"
        android:toXScale="0.1"
        android:toYScale="0.1" />
</set>
```
###上进下出
![这里写图片描述](http://img.blog.csdn.net/20160430002115867)
####R.anim.slide_in_up
```
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate
        android:duration="@android:integer/config_mediumAnimTime"
        android:interpolator = "@android:interpolator/accelerate_cubic"
        android:fromYDelta="-100%p"
        android:toXDelta="0" />

</set>
```
####R.anim.slide_out_down
```
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate android:fromYDelta="0"
        android:toYDelta="100%p"
        android:duration="@android:integer/config_mediumAnimTime"
        android:interpolator="@android:interpolator/accelerate_cubic"/>
</set>
```
###下进上出
![这里写图片描述](http://img.blog.csdn.net/20160430002130039)
####R.anim.slide_in_down
```
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate
        android:duration="@android:integer/config_mediumAnimTime"
        android:interpolator = "@android:interpolator/accelerate_cubic"
        android:fromYDelta="100%p"
        android:toYDelta="0" />
</set>
```
####R.anim.slide_out_top
```
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate
        android:duration="@android:integer/config_mediumAnimTime"
        android:interpolator = "@android:interpolator/accelerate_cubic"
        android:fromYDelta="0"
        android:toYDelta="-100%p" />
</set>
```


package com.wilin.tinkdemo.main.cityGuide;


import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Lin WenLong on 2018/6/2.
 * 用于标记item类型。
 */
@IntDef({CityGuideType.IMAGE, CityGuideType.DESCRIPTION})
@Retention(RetentionPolicy.SOURCE)
public @interface CityGuideType {
    /**
     * only image
     */
    int IMAGE = 0;
    /**
     * image with description.
     */
    int DESCRIPTION = 1;
}
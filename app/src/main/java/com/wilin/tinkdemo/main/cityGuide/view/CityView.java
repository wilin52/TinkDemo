package com.wilin.tinkdemo.main.cityGuide.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.wilin.tinkdemo.main.cityGuide.mode.CityGuideBean;

import java.util.List;

/**
 * Created by Lin WenLong on 2018/6/1.
 * load city guides.
 */
public interface CityView extends MvpView{
    /**
     * load guides successfully.
     * 成功返回列表
     * @param list guides of city.
     */
    void onCityGuideLoadSuccess(List<CityGuideBean> list);

    /**
     * fail to load guides of city.
     * 加载失败
     */
    void onCityGuideLoadFailure();
}

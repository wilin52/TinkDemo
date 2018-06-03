package com.wilin.tinkdemo.main.cityGuide.presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.wilin.tinkdemo.R;
import com.wilin.tinkdemo.framework.network.HttpClient;
import com.wilin.tinkdemo.framework.network.HttpManager;
import com.wilin.tinkdemo.framework.network.HttpUIHandler;
import com.wilin.tinkdemo.framework.utils.FileUtils;
import com.wilin.tinkdemo.main.cityGuide.mode.CityGuideBean;
import com.wilin.tinkdemo.main.cityGuide.view.CityView;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lin WenLong on 2018/6/1.
 * <p>
 * city guide.
 */
public class CityGuidePresenter extends MvpBasePresenter<CityView> {

    public void loadCityGuide(Context context) {
//        /**
//         * 网络请求。
//         * 已通过，用OK http。
//         */
//        try{
//            HttpManager.getInstance().execute(new HttpClient.Builder().setMethod(HttpClient.Builder.GET)
//                    .requestUrl("http://api.map.baidu.com/telematics/v3/weather?location=嘉兴&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ")
//                    .setMediaType(HttpClient.Builder.MEDIA_TYPE_JSON)
//                    .build(),new HttpUIHandler() {
//                        @Override
//                        public void onFailure(int errCode, String msg) {
//
//                        }
//
//                        @Override
//                        public void onSuccess(Objects... object) {
//                          // 处理数据。
//                        }
//
//                        @Override
//                        public void onException() {
//
//                        }
//                    });
//        } catch (Exception e){
//            Log.e("",e.toString());
//            e.printStackTrace();
//        }

        /**
         * 加载本地模拟数据。
         */
        String string = FileUtils.readFromRaw(context, R.raw.city_guide_samples);
        Gson gson = new Gson();
        List<CityGuideBean>list = gson.fromJson(string, new TypeToken<List<CityGuideBean>>(){}.getType());

        if (isViewAttached()) {
            getView().onCityGuideLoadSuccess(list);
        }
    }
}

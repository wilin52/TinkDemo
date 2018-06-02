package com.wilin.tinkdemo.main.cityGuide.presenter;

import android.util.Log;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.wilin.tinkdemo.framework.network.HttpClient;
import com.wilin.tinkdemo.framework.network.HttpManager;
import com.wilin.tinkdemo.framework.network.HttpUIHandler;
import com.wilin.tinkdemo.main.cityGuide.CityGuideType;
import com.wilin.tinkdemo.main.cityGuide.mode.CityGuideBean;
import com.wilin.tinkdemo.main.cityGuide.view.CityView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Lin WenLong on 2018/6/1.
 * <p>
 * city guide.
 */
public class CityGuidePresenter extends MvpBasePresenter<CityView> {

    public void loadCityGuide() {
        try{
            HttpManager.getInstance().execute(new HttpClient.Builder().setMethod(HttpClient.Builder.GET)
                    .requestUrl("http://api.map.baidu.com/telematics/v3/weather?location=嘉兴&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ")
                    .setMediaType(HttpClient.Builder.MEDIA_TYPE_JSON)
                    .build(),new HttpUIHandler() {
                        @Override
                        public void onFailure(int errCode, String msg) {

                        }

                        @Override
                        public void onSuccess(Objects... object) {

                        }

                        @Override
                        public void onException() {

                        }
                    });
        } catch (Exception e){
            Log.e("",e.toString());
            e.printStackTrace();
        }

        // test data. 测试数据
        CityGuideBean bean = new CityGuideBean();
        bean.setType(CityGuideType.DESCRIPTION);
        bean.setImageSrc("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527937061850&di=614c28a22a0217014a39c28b2f6c7556&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ff603918fa0ec08fa55fe063555ee3d6d54fbdaa1.jpg");
        bean.setDescriptionTitle("Woaw Store");
        bean.setDescription("Lifestyle-fashion store Woaw is in the hip district of SOHO, Surrounded by a slew of population. It attracts five thousand people everyday. It provides not only the start products and the service is also very nice.");
        CityGuideBean bean1 = new CityGuideBean();
        bean1.setType(CityGuideType.IMAGE);
        bean1.setImageSrc("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527937106422&di=512ab97c0a6c53da95d8fa2db83f8a20&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fa2cc7cd98d1001e98517929cb40e7bec54e7977e.jpg");
        CityGuideBean bean2 = new CityGuideBean();
        bean2.setType(CityGuideType.DESCRIPTION);
        bean2.setImageSrc("https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=df9096844d34970a5873162fa5cbd1c0/d043ad4bd11373f0f5413134a80f4bfbfbed041a.jpg");
        bean2.setDescriptionTitle("Armoury Hotel");
        bean2.setDescription("This photogenic store offers everything from artisanal men's shoes and blazer, to shirt and hat. It seems like more and more young will appreciate their products. And you will find what you want here.");
        CityGuideBean bean3 = new CityGuideBean();
        bean3.setType(CityGuideType.IMAGE);
        bean3.setImageSrc("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527937151153&di=41dd81b57029d92cb99e93880343a228&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F5882b2b7d0a20cf4cc07a34a7a094b36adaf9994.jpg");
        List<CityGuideBean> list = new ArrayList<>();
        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        if (isViewAttached()) {
            getView().onCityGuideLoadSuccess(list);
        }
    }
}

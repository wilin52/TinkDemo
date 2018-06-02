package com.wilin.tinkdemo.main.shop.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.wilin.tinkdemo.R;
import com.wilin.tinkdemo.framework.mvp.BaseMvpFragment;
import com.wilin.tinkdemo.main.shop.presenter.ShopPresenter;
import com.wilin.tinkdemo.main.shop.view.ShopView;

/**
 * Created by Lin WenLong on 2018/6/1.
 * 商店展示
 */
public class ShopFragment extends BaseMvpFragment<ShopView, ShopPresenter> implements ShopView{
    public static final String TAG = ShopFragment.class.getSimpleName();

    public static ShopFragment newInstance(){
        return new ShopFragment();
    }

    @NonNull
    @Override
    public ShopPresenter createPresenter() {
        return new ShopPresenter();
    }

    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_main_shop,container,false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}

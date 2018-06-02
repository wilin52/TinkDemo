package com.wilin.tinkdemo.main.eat.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wilin.tinkdemo.R;
import com.wilin.tinkdemo.framework.mvp.BaseMvpFragment;
import com.wilin.tinkdemo.main.eat.presenter.EatPresenter;
import com.wilin.tinkdemo.main.eat.view.EatView;

/**
 * Created by Lin WenLong on 2018/6/1.
 *
 * 饭店展示。
 */
public class EatFragment extends BaseMvpFragment<EatView,EatPresenter> {
    public static final String TAG = EatFragment.class.getSimpleName();

    public static EatFragment newInstance(){
        return new EatFragment();
    }

    @NonNull
    @Override
    public EatPresenter createPresenter() {
        return new EatPresenter();
    }

    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_main_eat,container,false);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}

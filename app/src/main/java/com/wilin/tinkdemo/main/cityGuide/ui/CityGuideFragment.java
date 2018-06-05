package com.wilin.tinkdemo.main.cityGuide.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wilin.tinkdemo.R;
import com.wilin.tinkdemo.framework.mvp.BaseMvpFragment;
import com.wilin.tinkdemo.main.cityGuide.mode.CityGuideBean;
import com.wilin.tinkdemo.main.cityGuide.presenter.CityGuidePresenter;
import com.wilin.tinkdemo.main.cityGuide.view.CityView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Lin WenLong on 2018/6/1.
 * city guide.
 */
public class CityGuideFragment extends BaseMvpFragment<CityView, CityGuidePresenter> implements CityView {
    public static final String TAG = CityGuideFragment.class.getSimpleName();

    @BindView(R.id.city_guide_recycler_view)
    XRecyclerView mRecyclerView;

    private CityGuideAdapter adapter;

    public static CityGuideFragment newInstance() {
        return new CityGuideFragment();
    }

    @NonNull
    @Override
    public CityGuidePresenter createPresenter() {
        return new CityGuidePresenter();
    }

    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_main_city_guide, container, false);
    }

    @Override
    protected void initData() {
        adapter = new CityGuideAdapter(this);

    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.ic_loading_rotate);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                /**
                 * 加载列表，load data.
                 */
                presenter.loadCityGuide(getContext());
            }

            @Override
            public void onLoadMore() {
                presenter.loadMoreCityGuide(getContext());
            }
        });
        mRecyclerView.refresh();
    }

    @Override
    public void onCityGuideLoadFailure() {

    }

    @Override
    public void onCityGuideLoadSuccess(List<CityGuideBean> list) {
        mRecyclerView.refreshComplete();
        adapter.setCityGuideBeanList(list);
    }

    @Override
    public void onCityGuideLoadMoreSuccess(List<CityGuideBean> list) {
        mRecyclerView.loadMoreComplete();
        adapter.addCityGuideBeanList(list);
    }
}

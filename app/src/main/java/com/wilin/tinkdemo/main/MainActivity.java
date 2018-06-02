package com.wilin.tinkdemo.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.wilin.tinkdemo.R;
import com.wilin.tinkdemo.framework.BaseActivity;

import butterknife.BindView;

/**
 * main tab.
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.table_layout)
    TabLayout tabLayout;

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void initView() {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(),this);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        /**
         * 三个标题
         */
        int count = adapter.getCount();
        for(int i = 0; i < count; i++){
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(adapter.getPageTitle(i));
            tabLayout.addTab(tab);
        }
        tabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void initData() {

    }
}

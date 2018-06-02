package com.wilin.tinkdemo.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wilin.tinkdemo.R;
import com.wilin.tinkdemo.main.cityGuide.ui.CityGuideFragment;
import com.wilin.tinkdemo.main.eat.ui.EatFragment;
import com.wilin.tinkdemo.main.shop.ui.ShopFragment;

/**
 * Created by Lin WenLong on 2018/6/1.
 *
 * Main Viewpager.
 */
class MainViewPagerAdapter extends FragmentPagerAdapter {
    private static final String[] TAG = new String[]{CityGuideFragment.TAG,ShopFragment.TAG, EatFragment.TAG};
    private final String[] FRAGMENT_TITLE;


    MainViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        FRAGMENT_TITLE = new String[]{context.getString(R.string.main_tab_city_guide),
                context.getString(R.string.main_tab_shop), context.getString(R.string.main_tab_eat)};
    }

    @Override
    public Fragment getItem(int position) {
        if(TAG[position].equals(ShopFragment.TAG)){
            return ShopFragment.newInstance();
        } else if(TAG[position].equals(EatFragment.TAG)){
            return EatFragment.newInstance();
        } else {
            return CityGuideFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return TAG.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FRAGMENT_TITLE[position];
    }

}

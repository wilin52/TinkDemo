package com.wilin.tinkdemo.main;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import com.wilin.tinkdemo.base.AbstractTestPage;

import static org.junit.Assert.assertTrue;

/**
 * Created by Lin WenLong on 2018/6/4.
 * test main.
 */
public class MainPageTest extends AbstractTestPage{

    @Override
    public void runTest() {

//        UiObject object = getUiDevice().findObject(new UiSelector().resourceId("com.wilin.tinkdemo:id/R.id.main_content"));
//        assertTrue(object.exists());

        try{

            /**
             * tab 点击
             */
            UiObject tabLayout = getUiDevice().findObject(new UiSelector().resourceId("com.wilin.tinkdemo:id/table_layout"));
            assertTrue(tabLayout.exists());
            UiObject shopTab = tabLayout.getChild(new UiSelector().index(1));
            assertTrue(shopTab.exists());
            shopTab.click();
            takeScreenshot("shop_click.png");

            /**
             * viewpager 滑动
             */
            UiScrollable viewpager = new UiScrollable(new UiSelector().className("android.support.v4.view.ViewPager"));

            assertTrue(viewpager.exists());
            try{
                viewpager.setAsHorizontalList();
                viewpager.scrollBackward();
                takeScreenshot("scroll_to_guide.png");
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
            }

        } catch (UiObjectNotFoundException e){
            e.printStackTrace();
        }




    }
}

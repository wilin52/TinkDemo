package com.wilin.tinkdemo.main.guide;

import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import com.wilin.tinkdemo.base.AbstractTestPage;

import static org.junit.Assert.assertTrue;

/**
 * Created by Lin WenLong on 2018/6/5.
 */

public class GuidePageTest extends AbstractTestPage {

    @Override
    public void runTest() {
        /**
         * recyclerView 滑动
         */
        UiScrollable recyclerView = new UiScrollable(new UiSelector().resourceId("com.wilin.tinkdemo:id/city_guide_recycler_view"));

        assertTrue(recyclerView.exists());
        try {
            recyclerView.setAsVerticalList();
            recyclerView.scrollToEnd(2);
            takeScreenshot("guide_scroll_to_end.png");
            recyclerView.scrollForward();
            takeScreenshot("guide_scroll_to_load_more.png");
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
}

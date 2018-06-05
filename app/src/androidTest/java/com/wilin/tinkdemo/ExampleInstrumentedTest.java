package com.wilin.tinkdemo;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wilin.tinkdemo.main.MainPageTest;
import com.wilin.tinkdemo.main.guide.GuidePageTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.wilin.tinkdemo", appContext.getPackageName());
        /**
         * 启动app， 否则会寻找UI item 失败。
         */
        Intent intent = appContext.getPackageManager().getLaunchIntentForPackage(appContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        appContext.startActivity(intent);

        MainPageTest mainPageTest = (MainPageTest)Class.forName("com.wilin.tinkdemo.main.MainPageTest").newInstance();
        mainPageTest.runTest();
        GuidePageTest guidePageTest = (GuidePageTest) Class.forName("com.wilin.tinkdemo.main.guide.GuidePageTest").newInstance();
        guidePageTest.runTest();
    }
}

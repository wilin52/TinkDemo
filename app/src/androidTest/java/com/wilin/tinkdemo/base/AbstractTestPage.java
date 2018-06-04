package com.wilin.tinkdemo.base;

import android.content.Context;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import com.wilin.tinkdemo.utils.FileUtils;

import org.junit.runner.RunWith;

import java.io.File;

/**
 * Created by Lin WenLong on 2018/6/4.
 * base test page.
 */
@RunWith(AndroidJUnit4.class)
public abstract class AbstractTestPage implements AutoTestInterface {
    private static final String APP_DIR = "will_demo";
    private static final String SCREENSHOT_DIR = "screenshot";

    public Context getContext() {
        return InstrumentationRegistry.getTargetContext();
    }

    public UiDevice getUiDevice() {
        return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Override
    public void takeScreenshot(String fileName) {

        try {
            Thread.sleep(1000);

            String screenshotAbsoluteDirPath = Environment.getExternalStorageDirectory().getAbsolutePath()
                    .concat(File.separator).concat(APP_DIR).concat(File.separator)
                    .concat(SCREENSHOT_DIR).concat(File.separator);
            getUiDevice().takeScreenshot(FileUtils.mkFile(screenshotAbsoluteDirPath + fileName));

            //保证截图的准确性
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

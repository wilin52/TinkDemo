package com.wilin.tinkdemo.base;

/**
 * Created by Lin WenLong on 2018/6/4.
 *
 * 定义自动化测试的方法.
 */
public interface AutoTestInterface {
    /**
     * test.
     */
    void runTest();

    /**
     * 截图.
     */
    void takeScreenshot(String fileName);
}

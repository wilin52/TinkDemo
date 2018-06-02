package com.wilin.tinkdemo.framework.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Lin WenLong on 2018/6/2.
 * <p>
 * 文件工具
 */
public class FileUtils {

    public static String readFromRaw(Context context, int resId) {
        try {
            InputStream is = context.getResources().openRawResource(resId);
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder("");
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

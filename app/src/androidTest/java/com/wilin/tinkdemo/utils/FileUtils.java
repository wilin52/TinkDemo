package com.wilin.tinkdemo.utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Lin WenLong on 2018/6/4.
 * file utils
 */
public class FileUtils {
    /**
     * 保存文件
     * @param filePath filePath
     */
    public static File mkFile(String filePath) {
        File file = new File(filePath);
        if (file.getParentFile().exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
            }
        } else {
            mkDir(file.getParentFile());
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        }

        return file;
    }

    /**
     * 递归创建文件夹
     *
     * @param file
     */
    private static void mkDir(File file) {
        if (file.getParentFile().exists()) {
            file.mkdir();
        } else {
            mkDir(file.getParentFile());
            file.mkdir();
        }
    }
}

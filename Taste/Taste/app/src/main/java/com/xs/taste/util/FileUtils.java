package com.xs.taste.util;

import android.content.Context;
import android.text.format.DateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Date on 2020/5/27 11:05
 * @Author joe
 * @Version 1.0
 * @Describe
 **/
public class FileUtils {

    /**
     * 新建图片文件
     *
     * @return
     * @throws IOException
     */
    public static File createImageFile(String pathname) throws IOException {
        File file = new File(pathname);
        file.createNewFile();
        return file;
    }


    private static void dumpFile(String fileName, byte[] data) {
        FileOutputStream outStream;
        try {
            outStream = new FileOutputStream(fileName);
        } catch (IOException ioe) {
            throw new RuntimeException("Unable to create output file " + fileName, ioe);
        }
        try {
            outStream.write(data);
            outStream.close();
        } catch (IOException ioe) {
            throw new RuntimeException("failed writing data to file " + fileName, ioe);
        }
    }
}

package com.xs.taste.util;

import android.util.Log;

import java.util.Arrays;

/**
 * @Date on 2020/5/27 9:43
 * @Author joe
 * @Version 1.0
 * @Describe 字节处理工具
 **/
public class ByteUtils {
    private static String TAG = "ByteUtils";

    /**
     * 打印一串字符串
     *
     * @param bs
     */
    public static void printByte(byte[] bs) {
    /*    for(int i=0;i<bs.length;i++){
         Log.d(TAG,"bs -->"+bs[i]);
        }*/
        Log.d(TAG, "bs -->" + Arrays.toString(bs));
    }

    /**
     * @param bs
     * @param bs2
     * @return 比较2个字节数组的内容是否相同
     */
    public static boolean isByteEquals(byte[] bs, byte[] bs2) {
        return Arrays.equals(bs, bs2);
    }


}

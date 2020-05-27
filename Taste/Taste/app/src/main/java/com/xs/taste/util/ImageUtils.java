package com.xs.taste.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.media.Image;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Date on 2020/5/27 9:32
 * @Author joe
 * @Version 1.0
 * @Describe 图像处理相关util
 * https://stackoverflow.com/questions/7620401/how-to-convert-byte-array-to-bitmap
 * https://stackoverflow.com/questions/25505973/how-do-i-convert-raw-camera-data-into-a-bitmap-on-android
 * <p>
 * png->bitmap->showBitMap;
 * Image->bitmap->showBitMap
 * Image->byte->bitMap->showBitMap
 **/
public class ImageUtils {

    private static String TAG = "ImageUtils";

    /**
     * 实现相机的raw data转BitMap;
     *
     * @param bs
     * @param width
     * @param height
     * @return
     */
    public Bitmap byteToBitmap(byte[] bs, int width, int height) {
        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bm.copyPixelsFromBuffer(ByteBuffer.wrap(bs));
        return bm;
    }


    /**
     * bitMap转 byte
     *
     * @param bitmap
     * @return
     */
    public byte[] BitmapToByte(Bitmap bitmap) {
        ByteArrayOutputStream blob = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /* Ignored for PNGs */, blob);
        byte[] bitMapData = blob.toByteArray();
        return bitMapData;
    }


    /**
     * 该方法生效的前提是提供的BitMap是提供图像参数的，而非简单的RGBA数据。
     *
     * @param bs
     * @return
     */
    public Bitmap byteToBitmap2(byte[] bs) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(bs, 0, bs.length);
        return bitmap;
    }


    /**
     * 文件转bitMap;
     *
     * @param path
     * @return
     */
    public Bitmap fileToBitmap(String path) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        return bitmap;
    }

    /**
     * bitMap转文件
     *
     * @param bitmap
     * @param path
     * @return
     */
    public static String bitMapToFile(Bitmap bitmap, String path) {
        if (bitmap == null) {
            Log.d("CPP", "bitMap is null");
            return null;
        }

        FileOutputStream fos = null;
        try {
            File file = FileUtils.createImageFile(path);
            fos = new FileOutputStream(file);
            boolean result = bitmap.compress(Bitmap.CompressFormat.PNG, 75, fos);
            if (result) {
                path = file.getAbsolutePath();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }

    /**
     * Image转 byte[]
     * @param mImage
     * @return
     */
    public static byte[] imageToByte(Image mImage) {
        ByteBuffer buffer = mImage.getPlanes()[0].getBuffer();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        return bytes;
    }

    /**
     * Image转 BitMap
      * @param image
     * @return
     */
    public static Bitmap imageToBitmap(Image image) {
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bytes = new byte[buffer.capacity()];
        buffer.get(bytes);
        Bitmap bitmapImage = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, null);
        return bitmapImage;
    }






}

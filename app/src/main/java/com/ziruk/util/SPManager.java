package com.ziruk.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Author by 宋棋安, Email sgngqian@sina.com
 * Date on 2018/11/15.
 */
public class SPManager {

    private static Context context;

    //创建当前类的实例
    private static SPManager mInstance;
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;
    //文件名
    private static final String SHARE_PREFERENCE_NAME = "notification.pre";
    //设备Token
    public static final String DEVICE_TOKEN = "device_token";
    //注册设备Token
    public static final String REGISTER_TOKEN = "is_um_register";

    //线程安全的返回本类对象的方法
    public static SPManager getInstance() {
    if (mInstance == null) {
        synchronized (SPManager.class) {
            if (mInstance == null) {
                if (context == null)
                    throw new RuntimeException("请在application中初始化");
                mInstance = new SPManager();
            }
        }
    }
    return mInstance;
    }

        public static void Bind(Application application) {
        context = application;
    }

        //私有的构造
    private SPManager() {
        sp = context.getSharedPreferences(SHARE_PREFERENCE_NAME,
                Context.MODE_PRIVATE);
        editor = sp.edit();
    }

        //对int类型数据的写入
        public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

        //对int类型数据的读取
        public int getInt(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

        //对long类型数据的写入
        public void putLong(String key, Long value) {
        editor.putLong(key, value);
        editor.commit();
    }

        //对long类型数据的读取
        public long getLong(String key, int defaultValue) {
        return sp.getLong(key, defaultValue);
    }

        //对string类型数据的写入
        public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

        //对string类型数据的读取
        public String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

        //对float类型数据的写入
        public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

        //对float类型数据的读取
        public float getFloat(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

        //对boolean类型数据的写入
        public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

        //对boolean类型数据的读取
        public boolean getBoolean(String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

        //判断key是否存在
        public boolean isKeyExist(String key) {
        return sp.contains(key);
    }

        //删除单个数据,按照key类型
        public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }

        //删除所有数据
        public void removeAllSPData() {
        editor.clear().commit();
    }

}

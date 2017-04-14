package com.emrahakbiyik.gts.Objects;

import android.content.Context;

/**
 * Created by eakbiyik on 6.12.2015.
 */
public class SharedPref {
    TinyDB tinyDB;
    private static SharedPref instance = null;
    public static synchronized SharedPref getInstance(Context mContext) {
        if (instance == null) {
            instance = new SharedPref(mContext);
        }
        return instance;
    }

    private SharedPref(Context mContext) {
        tinyDB = new TinyDB(mContext);
    }

    public void clear() {
        tinyDB.clear();
    }
}

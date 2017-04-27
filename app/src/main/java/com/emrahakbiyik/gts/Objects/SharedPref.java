package com.emrahakbiyik.gts.Objects;
import android.content.Context;
import java.util.ArrayList;

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

    public ArrayList<Arac> getAraclist() {
        ArrayList<Arac> mAracList= (ArrayList<Arac>)(Object) tinyDB.getListObject("Arac", Arac.class);
        return mAracList;
    }

    public void addArac(Arac arac){
        ArrayList<Arac> mAracList= getAraclist();
        mAracList.add(arac);
        tinyDB.putListObject("Arac",(ArrayList)mAracList);
    }

    public Arac getArac(String id){

        Arac rArac = new Arac();
        ArrayList<Arac> mAracList= getAraclist();
        for (Arac nArac: mAracList
             ) {

            if (nArac.getAracID().equals(id)){
                rArac= nArac;
            }
        }
        return rArac;
    }

    public void clear() {
        tinyDB.clear();
    }
}

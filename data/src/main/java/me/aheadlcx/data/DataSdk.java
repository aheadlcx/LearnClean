package me.aheadlcx.data;

import android.content.Context;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:58
 */
public class DataSdk {

    private Context mContext;
    private static DataSdk sDataSdk;
    public DataSdk() {

    }
    public static DataSdk getInstance(){
        if (sDataSdk == null) {
            sDataSdk = new DataSdk();
        }
        return sDataSdk;
    }

    public void init(Context context){
        this.mContext = context;
    }

    public Context getContext(){
        return mContext;
    }
}

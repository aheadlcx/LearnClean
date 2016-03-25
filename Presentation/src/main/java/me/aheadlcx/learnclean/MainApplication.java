package me.aheadlcx.learnclean;

import android.app.Application;

import me.aheadlcx.data.DataSdk;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午7:00
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataSdk.getInstance().init(this);
    }
}

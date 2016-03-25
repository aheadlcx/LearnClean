package me.aheadlcx.learnclean.cate.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

import me.aheadlcx.learnclean.baseui.BaseActivity;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午4:39
 */
public class CateActivity extends BaseActivity {
    private static final String TAG = "CateActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .add(Window.ID_ANDROID_CONTENT , new CateFragment(), TAG)
                .commit();
    }
}

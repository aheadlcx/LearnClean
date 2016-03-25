package me.aheadlcx.learnclean.baseui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午3:25
 */
public class BaseFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresent();
    }

    public void initPresent() {

    }
}

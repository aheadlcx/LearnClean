package me.aheadlcx.learnclean.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import me.aheadlcx.learnclean.R;
import me.aheadlcx.learnclean.baseui.BaseActivity;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/25 上午10:12
 */
public class ForTestActivity extends BaseActivity {
    private TextView txtShowLife;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test);
        txtShowLife = (TextView) findViewById(R.id.txtShowLife);
    }

    @Override
    protected void onResume() {
        txtShowLife.setText("hello onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        txtShowLife.setText("hello onPause");
        super.onPause();

    }
}

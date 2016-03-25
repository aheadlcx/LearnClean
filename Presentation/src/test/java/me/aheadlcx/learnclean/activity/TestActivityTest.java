package me.aheadlcx.learnclean.activity;

import android.util.Log;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import me.aheadlcx.learnclean.BuildConfig;
import me.aheadlcx.learnclean.R;
import me.aheadlcx.learnclean.test.ForTestActivity;

import static junit.framework.Assert.assertNotNull;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/25 上午10:17
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class TestActivityTest {
    private static final String TAG = "TestActivityTest";

    private TextView txtShowLife;

    @Before
    public void setUp() {

    }

    @Test
    public void testActivity() {
        ForTestActivity forTestActivity = Robolectric.setupActivity(ForTestActivity.class);
        assertNotNull(forTestActivity);

    }

    @Test
    public void testLifecycle() {
        ActivityController<ForTestActivity> start = Robolectric.buildActivity(ForTestActivity.class).create().start();
        ForTestActivity forTestActivity = start.get();
        TextView txtShow = (TextView) forTestActivity.findViewById(R.id.txtShowLife);
//        assertEquals("onCreate", txtShow.getText().toString());
        String content = "";
        content = txtShow.getText().toString();
        Log.i(TAG, "testLifecycle: --start" + content);
        start.resume();
        content = txtShow.getText().toString();
        Log.i(TAG, "testLifecycle: -- onResume" + content);

        start.pause();
        content = txtShow.getText().toString();
        Log.i(TAG, "testLifecycle: -- onPause" + content);
    }
}

package me.aheadlcx.learnclean.cate.present;

import android.content.Context;
import android.util.Log;

import java.util.List;

import me.aheadlcx.domain.CateCase;
import me.aheadlcx.domain.DefaultSubscriber;
import me.aheadlcx.domain.Cate;
import me.aheadlcx.learnclean.cate.viewinterface.CateIUi;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午3:25
 */
public class CatePresent {
    private static final String TAG = "CatePresent";

    private Context mContext;
    private CateIUi mUi;
    private CateCase mCateCase;

    public void setCateCase(CateCase cateCase) {
        mCateCase = cateCase;
    }

    public CatePresent(Context context, CateIUi ui) {
        mContext = context;
        mUi = ui;
    }

    public void getData() {
        mCateCase.execute(new UserListSubscriber());

    }

    public void onDestory(){
        if (mCateCase != null) {
            mCateCase.unsubscribe();
        }
    }

    private final class UserListSubscriber extends DefaultSubscriber<List<Cate>> {

        @Override
        public void onCompleted() {
            Log.i(TAG, "onCompleted: ");
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: ",e );
        }

        @Override
        public void onNext(List<Cate> cates) {
            Log.i(TAG, "onNext: ");
            mUi.fillData(cates);
        }
    }
}

package me.aheadlcx.data.repositiry;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import me.aheadlcx.data.DataSdk;
import me.aheadlcx.data.api.CateService;
import me.aheadlcx.data.entity.CateEntity;
import me.aheadlcx.data.servermodel.cate.CateBean;
import me.aheadlcx.data.servermodel.cate.CateResponse;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:42
 */
public class CloundCateDataStore implements CateDataStore {
    @Override
    public Observable<List<CateEntity>> cateEntityList() {
        CateService cateService = getRetrofit().create(CateService.class);
        Observable<CateResponse> cateLists = cateService.getCateLists("134", "1", "100");
        Observable<List<CateEntity>> map = cateLists.map(new Func1<CateResponse, List<CateEntity>>() {
            @Override
            public List<CateEntity> call(CateResponse cateResponse) {
                ArrayList<CateEntity> lists = new ArrayList<CateEntity>();
                List<CateBean> result = cateResponse.getResult();
                CateEntity cate;
                for (CateBean bean : result) {
                    cate = transform(bean);
                    lists.add(cate);
                }
                return lists;
            }
        });
        return map;
    }

    private CateEntity transform(CateBean bean) {
        CateEntity cateEntity = new CateEntity();
        cateEntity.setContent(bean.getChannel().getExt().getT())
                .setPic(bean.getChannel().getPic().getBase() + bean.getChannel().getPic().getM());
        return cateEntity;
    }

    public Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.miaopai.com/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit;
    }

    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) DataSdk.getInstance().getContext().getSystemService(Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}

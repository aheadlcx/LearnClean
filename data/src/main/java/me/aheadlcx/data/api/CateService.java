package me.aheadlcx.data.api;

import me.aheadlcx.data.servermodel.cate.CateResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:47
 */
public interface CateService {
    @GET("m/cate2_channel")
    Observable<CateResponse> getCateLists(@Query("cateid") String cateid, @Query
            ("page") String page, @Query("per") String per );
}

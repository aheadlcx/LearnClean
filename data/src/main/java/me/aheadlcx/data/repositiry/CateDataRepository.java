package me.aheadlcx.data.repositiry;

import java.util.List;

import me.aheadlcx.data.entity.mapper.CateMapper;
import me.aheadlcx.domain.Cate;
import me.aheadlcx.domain.CateRepository;
import rx.Observable;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:15
 */
public class CateDataRepository implements CateRepository {
    @Override
    public Observable<List<Cate>> cates() {
        CateDataStoreFactory factory = new CateDataStoreFactory();
        CateDataStore cloundDataStore = factory.createCloundDataStore();
        Observable<List<Cate>> map = CateMapper.transform(cloundDataStore.cateEntityList());
        return map;
    }
}

package me.aheadlcx.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import me.aheadlcx.data.entity.CateEntity;
import me.aheadlcx.domain.Cate;
import rx.Observable;
import rx.functions.Func1;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午8:04
 */
public class CateMapper {

    public static Observable<List<Cate>> transform(Observable<List<CateEntity>> observable){
        Observable<List<Cate>> map = observable.map(new Func1<List<CateEntity>, List<Cate>>() {
            @Override
            public List<Cate> call(List<CateEntity> cateEntities) {
                List<Cate> cates = new ArrayList<Cate>();
                Cate cate;
                for (CateEntity entity : cateEntities) {
                    if (entity == null) {
                        continue;
                    }
                    cate = new Cate().setContent(entity.getContent()).setPic(entity.getPic());
                    cates.add(cate);
                }
                return cates;
            }
        });
        return map;
    }
}

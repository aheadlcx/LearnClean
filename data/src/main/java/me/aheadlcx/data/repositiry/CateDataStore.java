package me.aheadlcx.data.repositiry;

import java.util.List;

import me.aheadlcx.data.entity.CateEntity;
import rx.Observable;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:40
 */
public interface CateDataStore {
    Observable<List<CateEntity>> cateEntityList();

}

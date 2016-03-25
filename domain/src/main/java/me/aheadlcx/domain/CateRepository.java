package me.aheadlcx.domain;

import java.util.List;

import rx.Observable;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:07
 */
public interface CateRepository {
    Observable<List<Cate>> cates();

}

package me.aheadlcx.domain;

import rx.Observable;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:06
 */
public class GetCateList extends CateCase {

    private CateRepository mCateRepository;

    public GetCateList(PostExecutionThread postExecutionThread, CateRepository cateRepository) {
        super(postExecutionThread);
        mCateRepository = cateRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mCateRepository.cates();
    }
}

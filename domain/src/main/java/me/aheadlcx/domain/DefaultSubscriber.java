package me.aheadlcx.domain;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午5:45
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {
    @Override public void onCompleted() {
        // no-op by default.
    }

    @Override public void onError(Throwable e) {
        // no-op by default.
    }

    @Override public void onNext(T t) {
        // no-op by default.
    }
}
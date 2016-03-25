package me.aheadlcx.domain;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:00
 */
public abstract class CateCase {
    private Subscription subscription = Subscriptions.empty();
    private PostExecutionThread mPostExecutionThread;

    public CateCase(PostExecutionThread postExecutionThread) {
        mPostExecutionThread = postExecutionThread;
    }

    protected abstract Observable buildUseCaseObservable();

    public void execute(Subscriber UseCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribe(UseCaseSubscriber);
    }

    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}

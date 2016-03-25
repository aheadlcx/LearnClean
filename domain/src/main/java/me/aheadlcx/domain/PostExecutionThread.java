package me.aheadlcx.domain;

import rx.Scheduler;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:04
 */
public interface PostExecutionThread {
    Scheduler getScheduler();

}

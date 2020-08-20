package com.sdy.ratelimiter.support;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 20:08
 * @description: 固定时间窗口限流算法
 */
public interface RateLimitAlg {
    boolean tryAcquire() throws Exception;
}

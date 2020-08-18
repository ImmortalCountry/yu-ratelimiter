package com.sdy.ratelimiter;

import org.junit.Test;

/**
 * @author: SunDeYu
 * @date: 2020/8/18 14:26
 * @description:
 */
public class RateLimiterTest {

    @Test
    public void getRule() {
        RateLimiter limiter = new RateLimiter();
        System.out.println(limiter.getRule());
    }
}
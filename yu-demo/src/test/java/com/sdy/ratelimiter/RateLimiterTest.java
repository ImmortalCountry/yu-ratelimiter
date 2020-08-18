package com.sdy.ratelimiter;

import jdk.nashorn.internal.runtime.logging.Logger;
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

    @Test
    public void limiter() throws Exception {
        RateLimiter limiter = new RateLimiter();
        // 5s 一次
        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            if (limiter.limit("1", "1")) {
                System.out.println("我执行啦 : " + i);
            } else {
                System.out.println("我被限流啦" + i);
            }
        }
    }
}
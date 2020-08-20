package com.sdy.ratelimiter.io.parse;

import com.sdy.ratelimiter.io.model.LimitConfig;

/**
 * @author: SunDeYu
 * @date: 2020/8/20 11:56
 * @description:
 */
public interface RateLimitRule {
    /**
     * 树型结构获取 ApiLimit
     * @param appId
     * @param api
     * @return
     */
    LimitConfig getLimit(String appId, String api);
}

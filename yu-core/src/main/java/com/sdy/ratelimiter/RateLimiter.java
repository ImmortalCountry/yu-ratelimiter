package com.sdy.ratelimiter;

import com.sdy.ratelimiter.io.config.FileRuleConfigSource;
import com.sdy.ratelimiter.io.config.RuleConfigSource;
import com.sdy.ratelimiter.io.model.LimitConfig;
import com.sdy.ratelimiter.io.model.RuleConfig;
import com.sdy.ratelimiter.io.parse.RateLimitRule;
import com.sdy.ratelimiter.io.parse.TrieRateLimitRule;
import com.sdy.ratelimiter.support.FixedTimeWinRateLimitAlg;
import com.sdy.ratelimiter.support.RateLimitAlg;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: SunDeYu
 * @date: 2020/8/20 11:51
 * @description:
 */
public class RateLimiter {
    /**
     * 为每个api在内存中存储限流计数器
     */
    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public RateLimitRule getRule() {
        return rule;
    }

    public RateLimiter(){
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();
        this.rule = new TrieRateLimitRule(ruleConfig);
    }
    public boolean limit(String appId, String url) throws Exception {
        LimitConfig apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null) {
            return true;
        }
        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = new FixedTimeWinRateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }
        // 判断是否限流
        return rateLimitCounter.tryAcquire();
    }

}

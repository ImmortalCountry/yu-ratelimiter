package com.sdy.ratelimiter.io.parse;

import com.sdy.ratelimiter.io.model.LimitConfig;
import com.sdy.ratelimiter.io.model.RuleConfig;

/**
 * @author: SunDeYu
 * @date: 2020/8/20 14:05
 * @description:
 */
public class TrieRateLimitRule implements RateLimitRule {
    private RuleConfig ruleConfig;

    public TrieRateLimitRule(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    @Override
    public LimitConfig getLimit(String appId, String api) {
        return ruleConfig.getConfigs().get(0).getLimits().get(0);
    }
}

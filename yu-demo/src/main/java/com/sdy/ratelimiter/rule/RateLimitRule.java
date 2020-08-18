package com.sdy.ratelimiter.rule;

import lombok.Data;

/**
 * @author: SunDeYu
 * @date: 2020/8/18 11:27
 * @description:
 */
@Data
public class RateLimitRule {
    private RuleConfig ruleConfig;

    public RateLimitRule(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }
    public ApiLimit getLimit(String appId, String api) {
        // todo
        return null;
    }
}

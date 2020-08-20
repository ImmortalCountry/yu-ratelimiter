package com.sdy.ratelimiter.io.model;

import java.util.List;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 20:04
 * @description:
 */
public class AppRuleConfig {
    private String appId;
    private List<LimitConfig> limits;

    public List<LimitConfig> getLimits() {
        return limits;
    }

    public void setLimits(List<LimitConfig> limits) {
        this.limits = limits;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

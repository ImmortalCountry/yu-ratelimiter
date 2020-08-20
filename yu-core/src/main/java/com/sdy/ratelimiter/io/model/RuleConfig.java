package com.sdy.ratelimiter.io.model;

import java.util.List;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 20:04
 * @description:
 */
public class RuleConfig {
    private List<AppRuleConfig> configs;

    public List<AppRuleConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<AppRuleConfig> configs) {
        this.configs = configs;
    }
}

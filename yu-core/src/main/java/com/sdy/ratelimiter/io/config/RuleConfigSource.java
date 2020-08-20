package com.sdy.ratelimiter.io.config;

import com.sdy.ratelimiter.io.model.RuleConfig;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 19:55
 * @description:
 */
public interface RuleConfigSource {
    RuleConfig load();
}

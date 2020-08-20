package com.sdy.ratelimiter.io.parse;

import com.sdy.ratelimiter.io.model.RuleConfig;

import java.io.InputStream;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 19:44
 * @description: 规则解析
 */
public interface RuleConfigParser {
    RuleConfig parse(String configText);
    RuleConfig parse(InputStream in);

}

package com.sdy.context;

import com.sdy.context.config.RuleConfigParser;
import com.sdy.context.config.YamlRuleConfigParser;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 19:42
 * @description:
 */
public class RuleConfigParserFactory {
    private RuleConfigParserFactory() {

    }

    public static RuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}

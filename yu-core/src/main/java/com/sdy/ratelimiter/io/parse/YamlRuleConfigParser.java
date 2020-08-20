package com.sdy.ratelimiter.io.parse;

import com.sdy.ratelimiter.io.model.RuleConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * @author: SunDeYu
 * @date: 2020/8/20 11:31
 * @description:
 */
public class YamlRuleConfigParser implements RuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return null;
    }

    @Override
    public RuleConfig parse(InputStream in) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(in, RuleConfig.class);
    }
}

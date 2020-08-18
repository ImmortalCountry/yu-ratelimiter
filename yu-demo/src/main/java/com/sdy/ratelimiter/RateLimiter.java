package com.sdy.ratelimiter;

import com.sdy.ratelimiter.rule.ApiLimit;
import com.sdy.ratelimiter.rule.RateLimitRule;
import com.sdy.ratelimiter.rule.RuleConfig;
import com.sdy.ratelimiter.rule.alg.RateLimitAlg;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author: SunDeYu
 * @date: 2020/8/18 11:26
 * @description:
 */
@Data
public class RateLimiter {
    public static final Logger log = LoggerFactory.getLogger(RateLimiter.class);

    /**
     * 为每个 api 在内存中存储限流计数器
     */
    private ConcurrentHashMap<String, RateLimitAlg> counters;
    private RateLimitRule rule;

    public RateLimiter() {
        counters = new ConcurrentHashMap<>();
        // 将限流规则配置文件 ratelimiter-rule.yaml 中的内容读取到 RuleConfig 中
        InputStream in = null;
        RuleConfig ruleConfig = null;
        try {
            in = this.getClass().getResourceAsStream("/ratelimiter-rule.yaml");
            if (in != null) {
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, RuleConfig.class);
            }
        } catch (Exception e) {
            log.error("get yaml failed");
        }
        this.rule = new RateLimitRule(ruleConfig);
    }

    public boolean limit(String appId, String url) throws Exception {
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null) {
            return true;
        }

        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = new RateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }
        // 判断是否限流
        return rateLimitCounter.tryAcquire();
    }
}

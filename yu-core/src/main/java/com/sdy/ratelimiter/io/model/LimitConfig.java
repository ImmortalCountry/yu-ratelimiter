package com.sdy.ratelimiter.io.model;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 19:58
 * @description:
 */
public class LimitConfig {
    private static final int DEFAULT_TIME_UNIT = 1;
    private String api;
    private int limit;
    private int unit = DEFAULT_TIME_UNIT;

    public static int getDefaultTimeUnit() {
        return DEFAULT_TIME_UNIT;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public LimitConfig() {

    }
}

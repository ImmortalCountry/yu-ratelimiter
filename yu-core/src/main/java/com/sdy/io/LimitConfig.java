package com.sdy.io;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 19:58
 * @description:
 */
public class LimitConfig extends Config {
    private static final int DEFAULT_TIME_UNIT = 1;
    private int limit;
    private int unit = DEFAULT_TIME_UNIT;

    public LimitConfig() {

    }


    @Override
    public boolean exists() {
        return false;
    }
}

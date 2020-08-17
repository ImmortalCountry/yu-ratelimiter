package com.sdy.io;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 19:58
 * @description:
 */
public class Config implements Resource{
    private String ConfigName;

    @Override
    public boolean exists() {
        return false;
    }
}

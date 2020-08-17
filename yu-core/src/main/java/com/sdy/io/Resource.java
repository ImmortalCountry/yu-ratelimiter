package com.sdy.io;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 19:55
 * @description:
 */
public interface Resource {
    /**
     * 检查配置文件是否物理存在
     * @return
     */
    boolean exists();
}

package com.wgh.springboot.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgh on 2021/3/15.
 */
public class Cache {
    private Map<String, Object> map = new HashMap<String, Object>();

    public void set(String key, String value) {
        this.map.put(key, value);
    }

    public Object get(String key) {
        return this.map.get(key);
    }
}

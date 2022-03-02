package com.mercymodest.prototype;

import cn.hutool.core.util.RandomUtil;

/**
 * @author ZGH.MercyModest
 * @version V1.0.0
 */
public class PrototypeTest {
    public static void main(String[] args) {

        SimpleMybatisCacheTest simpleMybatisCacheTest = new SimpleMybatisCacheTest();

        final Integer id = 1;
        User first = simpleMybatisCacheTest.getUser(id);
        System.out.println(first);
        User second = simpleMybatisCacheTest.getUser(id);
        System.out.println(second);
        System.out.println(first == second);

        System.out.println(simpleMybatisCacheTest.getUser(Math.abs(RandomUtil.randomInt())));
    }
}

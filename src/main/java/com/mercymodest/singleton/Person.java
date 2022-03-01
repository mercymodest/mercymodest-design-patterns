package com.mercymodest.singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 双重校验饿汉式单例模式
 *
 * @author ZGH.MercyModest
 * @version V1.0.0
 */
@Setter
@Getter
public class Person {

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 姓名
     */
    private String name;

    /**
     * person 对象实例  tips: 保证多线程环境下的可见性
     */
    private static volatile Person INSTANCE;

    /**
     * 构造器私有化
     */
    private Person() {
    }

    /**
     * 获取 {@link  Person} 对象实例
     *
     * @return {@code person}  instance
     */
    public static Person getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (Person.class) {
                if (Objects.isNull(INSTANCE)) {
                    INSTANCE = new Person();
                }
            }
        }
        return INSTANCE;
    }
}

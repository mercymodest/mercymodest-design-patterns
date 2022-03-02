package com.mercymodest.prototype;

import cn.hutool.core.util.RandomUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ZGH.MercyModest
 * @version V1.0.0
 */
public class SimpleMybatisCacheTest {


    /**
     * 简要本地缓存
     * <pre>
     *      key: {@link  User#getId()}
     *      value: {@link  User#getUsername()}
     *  </pre>
     */
    private final Map<Integer, User> CACHE_MAP = new HashMap<>(1 << 2);

    /**
     * 通过 {@code id} 获取用户
     *
     * @param id {@code  id}
     * @return {@code User }
     */
    public User getUser(Integer id) {
        if (Objects.isNull(id)) {
            return null;
        }
        User user = CACHE_MAP.get(id);
        if (Objects.isNull(user)) {
            user = getUserFromDb(id);
            CACHE_MAP.put(id, user);
        }
        return user.clone();
    }

    /**
     * 模拟从数据库查询数据
     *
     * @param id {@code  id} 用户
     * @return {@code User }
     */
    private User getUserFromDb(Integer id) {
        return User.builder()
                .id(id)
                .username(RandomUtil.randomString(12))
                .build();
    }
}

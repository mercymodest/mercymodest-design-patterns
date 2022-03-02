package com.mercymodest.prototype;

import cn.hutool.core.bean.BeanUtil;
import lombok.Builder;
import lombok.Data;

/**
 * @author ZGH.MercyModest
 * @version V1.0.0
 */
@Data
@Builder
public class User implements Cloneable {

    /**
     * id
     */
    private Integer id;

    /**
     * username
     */
    private String username;


    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public User clone() {
        try {
            return BeanUtil.copyProperties(this, User.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

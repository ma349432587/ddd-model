package com.mango.medical.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 请填写类的描述
 *
 * @author maxiaoyao
 * @date 2018-09-26 18:53
 */
@Getter
@Setter
public class User extends BasicEntity {
    private String name;
    private String phone;
    private String password;
    private int sex;
}

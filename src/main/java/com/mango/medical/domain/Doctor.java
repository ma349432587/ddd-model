package com.mango.medical.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 请填写类的描述
 *
 * @author maxiaoyao
 * @date 2018-09-25 20:06
 */
@Getter
@Setter
public class Doctor extends BasicEntity {
    private String name;
    private String phone;
}

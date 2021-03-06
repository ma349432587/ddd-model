package com.mango.medical.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 请填写类的描述
 *
 * @author maxiaoyao
 * @date 2018-09-26 16:09
 */
@Getter
@Setter
public class Pharmacist extends BasicEntity {
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String phone;
    /**
     *
     */
    private String idCard;
    /**
     *
     */
    private String licensedCode;
    /**
     *
     */
    private Long companyCode;
}

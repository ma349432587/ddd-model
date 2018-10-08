package com.mango.medical.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 请填写类的描述
 *
 * @author maxiaoyao
 * @date 2018-09-25 21:21
 */
@Getter
@Setter
public class Stock extends BasicEntity {

    /**
     *
     */
    private Long pharmacistId;
    /**
     *
     */
    private Long companyCode;
    /**
     * 单价
     */
    private Integer price;
    /**
     * 数量
     */
    private Integer amount;

}

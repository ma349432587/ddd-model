package com.mango.medical.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 请填写类的描述
 *
 * @author maxiaoyao
 * @date 2018-09-26 16:39
 */
@Getter
@Setter
public class RegisterRecord extends BasicEntity {
    private Long pharmacistId;
    private Long stockId;
    private Long patientId;
    private Long patientName;

}

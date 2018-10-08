package com.mango.medical.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 请填写类的描述
 *
 * @author maxiaoyao
 * @date 2018-10-08 17:31
 */
@Getter
@Setter
public class WeChatContext {
    private String openId;
    private String accessToken;
    private LocalDateTime expireTime;
}

package com.mango.medical.domain;

import com.mango.medical.utils.uuid.IdWorker;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 请填写类的描述
 *
 * @author maxiaoyao
 * @date 2018-09-25 20:07
 */

@Setter
@Getter
public class BasicEntity {

    private Long id;

    private Long recordId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;

    public Long getRecordId() {
        if (recordId == null) {
            recordId = IdWorker.getId();
        }
        return recordId;
    }

    public LocalDateTime getCreateTime() {
        if (createTime == null) {
            createTime = LocalDateTime.now();
        }
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        if (updateTime == null) {
            updateTime = LocalDateTime.now();
        }
        return updateTime;
    }
}

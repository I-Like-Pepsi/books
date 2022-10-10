package com.buydeem.common.dto.rep;

import lombok.Data;

@Data
public class RecordTypeRep {
    private Integer id;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 图标
     */
    private String icon;
}

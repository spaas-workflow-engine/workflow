package com.workflow.engine.process.domain.vo;

import lombok.Data;

/**
* @desc wf_ge_bytearray
* @author admin
*/
@Data
public class WfGeBytearrayVO {
    private Integer  id;
    private Integer  rev;
    private String name;
    private Integer  deploymentId;
    private String bytes;
    private Boolean prototype;
}


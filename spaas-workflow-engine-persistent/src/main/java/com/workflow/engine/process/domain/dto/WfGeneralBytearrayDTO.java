package com.workflow.engine.process.domain.dto;

import lombok.Data;

/**
* @desc wf_ge_bytearray
* @author admin
*/
@Data
public class WfGeneralBytearrayDTO {
    private Long  id;
    private Integer  rev;
    private String name;
    private Integer  deploymentId;
    private String bytes;
    private Boolean prototype;
}


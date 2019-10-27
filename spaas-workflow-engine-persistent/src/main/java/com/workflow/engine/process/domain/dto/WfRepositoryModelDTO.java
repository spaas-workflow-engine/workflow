package com.workflow.engine.process.domain.dto;


import lombok.Data;

import java.util.Date;


/**
* @desc wf_resource_model
* @author admin
*/
@Data
public class WfRepositoryModelDTO {

    private Long  id;
    private Integer  rev;
    private String name;
    private String code;
    private String category;
    private Date createTime;
    private Date lastUpdateTime;
    private Integer  version;
    private String metaInfo;
    private String deploymentId;
    private String editorSourceValueId;
    private String editorSourceExtraValueId;
    private String tenantId;

}


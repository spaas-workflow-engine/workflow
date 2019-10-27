package com.workflow.engine.process.domain.vo;


import lombok.Data;

import java.util.Date;


/**
* @desc wf_runtime_entitylink
* @author admin
*/
@Data
public class WfRuntimeEntitylinkVO {

    private Long  id;
    private Integer  rev;
    private Date createTime;
    private String linkType;
    private String scopeId;
    private String scopeType;
    private String scopeDefinitionId;
    private String refScopeId;
    private String refScopeType;
    private String refScopeDefinitionId;
    private String hierarchyType;

}


package com.workflow.engine.process.domain.dto;


import lombok.Data;

import java.util.Date;


/**
* @desc wf_runtime_suspended_job
* @author admin
*/
@Data
public class WfRuntimeSuspendedJobDTO {

    private Long  id;
    private Integer  rev;
    private String type;
    private Boolean exclusive;
    private Long  executionId;
    private Long  processInstanceId;
    private Long  procDefId;
    private String elementId;
    private String elementName;
    private String scopeId;
    private String subScopeId;
    private String scopeType;
    private String scopeDefinitionId;
    private Integer  retries;
    private String exceptionStackId;
    private String exceptionMsg;
    private Date duedate;
    private String duplicate;
    private String handlerType;
    private String handlerCfg;
    private String customValuesId;
    private Date createTime;
    private String tenantId;
}


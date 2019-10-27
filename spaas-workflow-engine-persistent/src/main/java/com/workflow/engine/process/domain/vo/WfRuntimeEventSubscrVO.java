package com.workflow.engine.process.domain.vo;


import lombok.Data;

import java.util.Date;


/**
* @desc wf_runtime_event_subscr
* @author admin
*/
@Data
public class WfRuntimeEventSubscrVO {


    private Long  id;
    private Integer  rev;
    private String eventType;
    private String eventName;
    private Long  executionId;
    private Long  procInstId;
    private Integer  wfivityId;
    private String configuration;
    private Date created;
    private String procDefId;
    private String subScopeId;
    private String scopeId;
    private String scopeDefinitionId;
    private String scopeType;
    private String tenantId;

}


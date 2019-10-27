package com.workflow.engine.process.domain.dto;


import lombok.Data;

import java.util.Date;


/**
* @desc wf_runtime_event_subscr
* @author admin
*/
@Data
public class WfRuntimeEventSubscrDTO {


    private Long  id;
    private Integer  rev;
    private String eventType;
    private String eventName;
    private Integer  executionId;
    private Integer  procInstId;
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


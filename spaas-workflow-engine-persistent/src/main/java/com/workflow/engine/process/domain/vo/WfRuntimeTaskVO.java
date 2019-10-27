package com.workflow.engine.process.domain.vo;

import lombok.Data;

import java.util.Date;

/**
* @desc wf_runtime_task
* @author admin
*/
@Data
public class WfRuntimeTaskVO {

    private Integer  id;
    private Integer  rev;
    private Integer  executionId;
    private Integer  procInstId;
    private Integer  procDefId;
    private Integer  taskDefId;
    private String scopeId;
    private String subScopeId;
    private String scopeType;
    private String scopeDefinitionId;
    private String name;
    private Integer  parentTaskId;
    private String description;
    private String taskDefKey;
    private String owner;
    private String assignee;
    private String delegation;
    private Integer  priority;
    private Date createTime;
    private Date dueDate;
    private String category;
    private Integer  suspensionState;
    private String tenantId;
    private String formKey;
    private Date claimTime;
    private Boolean isCountEnabled;
    private Integer  varCount;
    private Integer  idLinkCount;
    private Integer  subTaskCount;

}


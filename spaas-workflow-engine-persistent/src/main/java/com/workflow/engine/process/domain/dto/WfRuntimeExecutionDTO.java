package com.workflow.engine.process.domain.dto;

import lombok.Data;

import java.util.Date;

/**
* @desc wf_runtime_execution
* @author admin
*/
@Data
public class WfRuntimeExecutionDTO {
    private String businessKey;
    private Integer  parentId;
    private String procDefId;
    private String superExec;
    private String rootProcInstId;
    private String wfId;
    private Boolean isWfive;
    private Boolean isConcurrent;
    private Boolean isScope;
    private Boolean isEventScope;
    private Boolean isMiRoot;
    private Boolean suspensionState;
    private Integer  cachedEntState;
    private String tenantId;
    private String name;
    private String startWfId;
    private Date startTime;
    private String startUserId;
    private Date lockTime;
    private Boolean isCountEnabled;
    private Integer  evtSubscrCount;
    private Integer  taskCount;
    private Integer  jobCount;
    private Integer  timerJobCount;
    private Integer  suspJobCount;
    private Integer  deadletterJobCount;
    private Integer  varCount;
    private Integer  idLinkCount;
    private String callbackId;
    private String callbackType;
    private Integer  id;
    private Integer  rev;
    private Integer  procInstId;
}


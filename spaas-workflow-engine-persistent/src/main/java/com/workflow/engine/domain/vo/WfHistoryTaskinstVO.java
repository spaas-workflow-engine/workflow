package com.workflow.engine.domain.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
* @desc wf_history_taskinst
* @author admin
*/
@Data
public class WfHistoryTaskinstVO {

    private Long  id;

    private Integer  rev;

    private String procDefId;

    private String taskDefId;

    private String taskDefKey;

    private String procInstId;

    private String executionId;

    private String scopeId;

    private String subScopeId;

    private String scopeType;

    private String scopeDefinitionId;

    private String name;

    private String parentTaskId;

    private String description;

    private String owner;

    private String assignee;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date claimTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private Integer  duration;

    private String deleteReason;

    private Integer  priority;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dueDate;

    private String formKey;

    private String category;

    private String tenantId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedTime;

}


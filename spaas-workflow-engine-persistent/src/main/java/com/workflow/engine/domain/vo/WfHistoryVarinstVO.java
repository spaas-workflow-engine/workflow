package com.workflow.engine.domain.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
* @desc wf_history_varinst
* @author admin
*/
@Data
public class WfHistoryVarinstVO {

    private Long  id;

    private Integer  rev;

    private String procInstId;

    private String executionId;

    private String taskId;

    private String name;

    private String varType;

    private String scopeId;

    private String subScopeId;

    private String scopeType;

    private String bytearrayId;

    private Integer  doubleParam;

    private Integer  longParam;

    private String text;

    private String text2;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedTime;

    private String tenantId;

}


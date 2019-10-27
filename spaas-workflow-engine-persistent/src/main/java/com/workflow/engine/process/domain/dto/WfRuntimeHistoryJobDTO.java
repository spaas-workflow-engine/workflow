package com.workflow.engine.process.domain.dto;


import lombok.Data;

import java.util.Date;

/**
* @desc wf_runtime_history_job
* @author admin
*/
@Data
public class WfRuntimeHistoryJobDTO {

    private Integer  id;
    private Integer  rev;
    private Date lockExpTime;
    private String lockOwner;
    private Integer  retries;
    private Integer  exceptionStackId;
    private String exceptionMsg;
    private String handlerType;
    private String handlerCfg;
    private String customValuesId;
    private String advHandlerCfgId;
    private Date createTime;
    private String scopeType;
    private String tenantId;

}


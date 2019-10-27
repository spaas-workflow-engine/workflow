package com.workflow.engine.process.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
* @desc wf_history_actinst
* @author admin
*/
@Data
public class WfHistoryActinstDTO {
    private Integer  id;
    private Integer  rev;
    private String procDefId;
    private String procInstId;
    private String executionId;
    private String actId;
    private String taskId;
    private String callProcInstId;
    private String actName;
    private String actType;
    private String assignee;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private Integer  duration;
    private String deleteReason;
    private String tenantId;

}


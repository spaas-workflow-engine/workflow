package com.workflow.engine.process.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
* @desc wf_history_identitylink
* @author admin
*/
@Data
public class WfHistoryIdentitylinkDTO {

    private Integer  id;
    private String groupId;
    private String type;
    private String userId;
    private String taskId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String procInstId;
    private String scopeId;
    private String scopeType;
    private String scopeDefinitionId;
    private String tenantId;
}


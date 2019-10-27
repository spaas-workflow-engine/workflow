package com.workflow.engine.process.domain.vo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
* @desc wf_history_procinst
* @author admin
*/
@Data
public class WfHistoryProcinstVO {

    @TableId
    private Integer  id;
    private Integer  rev;
    private String procInstId;
    private String businessKey;
    private String procDefId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private Integer  duration;
    private String startUserId;
    private String startActId;
    private String endActId;
    private String superProcessInstanceId;
    private String deleteReason;
    private String tenantId;
    private String name;
    private String callbackId;
    private String callbackType;

}


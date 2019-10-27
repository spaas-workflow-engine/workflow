package com.workflow.engine.process.domain.vo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
* @desc wf_runtime_wfinst
* @author admin
*/
@TableName("wf_runtime_wfinst")
@Data
public class WfRuntimeWfinstVO {

    @TableId
    private Long  id;
    private Integer  rev;
    private Long  procDefId;
    private Long  procInstId;
    private Long  executionId;
    private Long  wfId;
    private Long  taskId;
    private Integer  callProcInstId;
    private String wfName;
    private String wfType;
    private String assignee;
    private Date startTime;
    private Date endTime;
    private Integer  duration;
    private String deleteReason;
    private String tenantId;

}


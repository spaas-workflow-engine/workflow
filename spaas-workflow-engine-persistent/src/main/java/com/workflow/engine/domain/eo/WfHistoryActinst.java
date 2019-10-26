package com.workflow.engine.domain.eo;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
* @desc wf_history_actinst
* @author admin
*/
@Data
@TableName("wf_history_actinst")
public class WfHistoryActinst{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`proc_def_id`")
    private String procDefId;
    @TableField(value = "`proc_inst_id`")
    private String procInstId;
    @TableField(value = "`execution_id`")
    private String executionId;
    @TableField(value = "`act_id`")
    private String actId;
    @TableField(value = "`task_id`")
    private String taskId;
    @TableField(value = "`call_proc_inst_id`")
    private String callProcInstId;
    @TableField(value = "`act_name`")
    private String actName;
    @TableField(value = "`act_type`")
    private String actType;
    @TableField(value = "`assignee`")
    private String assignee;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`start_time`")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`end_time`")
    private Date endTime;
    @TableField(value = "`duration`")
    private Integer  duration;
    @TableField(value = "`delete_reason`")
    private String deleteReason;
    @TableField(value = "`tenant_id`")
    private String tenantId;



}


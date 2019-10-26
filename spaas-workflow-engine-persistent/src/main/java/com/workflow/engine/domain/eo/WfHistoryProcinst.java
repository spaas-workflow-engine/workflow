package com.workflow.engine.domain.eo;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


/**
* @desc wf_history_procinst
* @author admin
*/
@Data
@TableName("wf_history_procinst")
public class WfHistoryProcinst{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`proc_inst_id`")
    private String procInstId;
    @TableField(value = "`business_key`")
    private String businessKey;
    @TableField(value = "`proc_def_id`")
    private String procDefId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`start_time`")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`end_time`")
    private Date endTime;
    @TableField(value = "`duration`")
    private Integer  duration;
    @TableField(value = "`start_user_id`")
    private String startUserId;
    @TableField(value = "`start_act_id`")
    private String startActId;
    @TableField(value = "`end_act_id`")
    private String endActId;
    @TableField(value = "`super_process_instance_id`")
    private String superProcessInstanceId;
    @TableField(value = "`delete_reason`")
    private String deleteReason;
    @TableField(value = "`tenant_id`")
    private String tenantId;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`callback_id`")
    private String callbackId;
    @TableField(value = "`callback_type`")
    private String callbackType;

}


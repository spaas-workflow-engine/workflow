package com.workflow.engine.process.domain.eo;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


/**
* @desc wf_history_taskinst
* @author admin
*/
@TableName("wf_history_taskinst")
@Data
public class WfHistoryTaskinst{

    @TableId
    @TableField(value = "`id`")
    private Long  id;

    @TableField(value = "`rev`")
    private Integer  rev;

    @TableField(value = "`proc_def_id`")
    private String procDefId;

    @TableField(value = "`task_def_id`")
    private String taskDefId;

    @TableField(value = "`task_def_key`")
    private String taskDefKey;

    @TableField(value = "`proc_inst_id`")
    private String procInstId;

    @TableField(value = "`execution_id`")
    private String executionId;

    @TableField(value = "`scope_id`")
    private String scopeId;

    @TableField(value = "`sub_scope_id`")
    private String subScopeId;

    @TableField(value = "`scope_type`")
    private String scopeType;

    @TableField(value = "`scope_definition_id`")
    private String scopeDefinitionId;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "`parent_task_id`")
    private String parentTaskId;

    @TableField(value = "`description`")
    private String description;

    @TableField(value = "`owner`")
    private String owner;

    @TableField(value = "`assignee`")
    private String assignee;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`start_time`")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`claim_time`")
    private Date claimTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`end_time`")
    private Date endTime;

    @TableField(value = "`duration`")
    private Integer  duration;

    @TableField(value = "`delete_reason`")
    private String deleteReason;

    @TableField(value = "`priority`")
    private Integer  priority;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`due_date`")
    private Date dueDate;

    @TableField(value = "`form_key`")
    private String formKey;

    @TableField(value = "`category`")
    private String category;

    @TableField(value = "`tenant_id`")
    private String tenantId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`last_updated_time`")
    private Date lastUpdatedTime;

}


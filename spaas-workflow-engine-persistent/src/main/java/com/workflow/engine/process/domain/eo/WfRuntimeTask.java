package com.workflow.engine.process.domain.eo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
* @desc wf_runtime_task
* @author admin
*/
@Data
@TableName("wf_runtime_historyjob")
public class WfRuntimeTask{

    @TableId
    @TableField(value = "`id`")
    private Long  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`execution_id`")
    private Long  executionId;
    @TableField(value = "`proc_inst_id`")
    private Long  procInstId;
    @TableField(value = "`proc_def_id`")
    private Long  procDefId;
    @TableField(value = "`task_def_id`")
    private Long  taskDefId;
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
    private Integer  parentTaskId;
    @TableField(value = "`description`")
    private String description;
    @TableField(value = "`task_def_key`")
    private String taskDefKey;
    @TableField(value = "`owner`")
    private String owner;
    @TableField(value = "`assignee`")
    private String assignee;
    @TableField(value = "`delegation`")
    private String delegation;
    @TableField(value = "`priority`")
    private Integer  priority;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`create_time`")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`due_date`")
    private Date dueDate;
    @TableField(value = "`category`")
    private String category;
    @TableField(value = "`suspension_state`")
    private Integer  suspensionState;
    @TableField(value = "`tenant_id`")
    private String tenantId;
    @TableField(value = "`form_key`")
    private String formKey;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`claim_time`")
    private Date claimTime;
    @TableField(value = "`is_count_enabled`")
    private Boolean isCountEnabled;
    @TableField(value = "`var_count`")
    private Integer  varCount;
    @TableField(value = "`id_link_count`")
    private Integer  idLinkCount;
    @TableField(value = "`sub_task_count`")
    private Integer  subTaskCount;

}


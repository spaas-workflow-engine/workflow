package com.workflow.engine.process.domain.eo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
* @desc wf_runtime_timer_job
* @author admin
*/
@TableName("wf_runtime_timer_job")
@Data
public class WfRuntimeTimerJob{

    @TableId
    @TableField(value = "`id`")
    private Long  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`type`")
    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`lock_exp_time`")
    private Date lockExpTime;
    @TableField(value = "`lock_owner`")
    private String lockOwner;
    @TableField(value = "`exclusive`")
    private Boolean exclusive;
    @TableField(value = "`execution_id`")
    private Long  executionId;
    @TableField(value = "`process_instance_id`")
    private Long  processInstanceId;
    @TableField(value = "`proc_def_id`")
    private Long  procDefId;
    @TableField(value = "`element_id`")
    private String elementId;
    @TableField(value = "`element_name`")
    private String elementName;
    @TableField(value = "`scope_id`")
    private String scopeId;
    @TableField(value = "`sub_scope_id`")
    private String subScopeId;
    @TableField(value = "`scope_type`")
    private String scopeType;
    @TableField(value = "`scope_definition_id`")
    private String scopeDefinitionId;
    @TableField(value = "`retries`")
    private Integer  retries;
    @TableField(value = "`exception_stack_id`")
    private String exceptionStackId;
    @TableField(value = "`exception_msg`")
    private String exceptionMsg;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`duedate`")
    private Date duedate;
    @TableField(value = "`duplicate`")
    private String duplicate;
    @TableField(value = "`handler_type`")
    private String handlerType;
    @TableField(value = "`handler_cfg`")
    private String handlerCfg;
    @TableField(value = "`custom_values_id`")
    private String customValuesId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`create_time`")
    private Date createTime;
    @TableField(value = "`tenant_id`")
    private String tenantId;

}


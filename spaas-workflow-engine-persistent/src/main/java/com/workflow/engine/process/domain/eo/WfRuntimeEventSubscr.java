package com.workflow.engine.process.domain.eo;


import java.util.Date;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Collection;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
* @desc wf_runtime_event_subscr
* @author admin
*/
@TableName("wf_runtime_eventsubscr")
@Data
public class WfRuntimeEventSubscr{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`event_type`")
    private String eventType;
    @TableField(value = "`event_name`")
    private String eventName;
    @TableField(value = "`execution_id`")
    private Integer  executionId;
    @TableField(value = "`proc_inst_id`")
    private Integer  procInstId;
    @TableField(value = "`wfivity_id`")
    private Integer  wfivityId;
    @TableField(value = "`configuration`")
    private String configuration;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`created`")
    private Date created;
    @TableField(value = "`proc_def_id`")
    private String procDefId;
    @TableField(value = "`sub_scope_id`")
    private String subScopeId;
    @TableField(value = "`scope_id`")
    private String scopeId;
    @TableField(value = "`scope_definition_id`")
    private String scopeDefinitionId;
    @TableField(value = "`scope_type`")
    private String scopeType;
    @TableField(value = "`tenant_id`")
    private String tenantId;

}


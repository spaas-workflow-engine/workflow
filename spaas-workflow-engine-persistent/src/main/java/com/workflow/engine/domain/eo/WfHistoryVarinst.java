package com.workflow.engine.domain.eo;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


/**
* @desc wf_history_varinst
* @author admin
*/
@Data
@TableName("wf_history_varinst")
public class WfHistoryVarinst{

    @TableId
    @TableField(value = "`id`")
    private Long  id;

    @TableField(value = "`rev`")
    private Integer  rev;

    @TableField(value = "`proc_inst_id`")
    private String procInstId;

    @TableField(value = "`execution_id`")
    private String executionId;

    @TableField(value = "`task_id`")
    private String taskId;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "`var_type`")
    private String varType;

    @TableField(value = "`scope_id`")
    private String scopeId;

    @TableField(value = "`sub_scope_id`")
    private String subScopeId;

    @TableField(value = "`scope_type`")
    private String scopeType;

    @TableField(value = "`bytearray_id`")
    private String bytearrayId;

    @TableField(value = "`double_param`")
    private Integer  doubleParam;

    @TableField(value = "`long_param`")
    private Integer  longParam;

    @TableField(value = "`text`")
    private String text;

    @TableField(value = "`text2`")
    private String text2;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`create_time`")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`last_updated_time`")
    private Date lastUpdatedTime;

    @TableField(value = "`tenant_id`")
    private String tenantId;

}


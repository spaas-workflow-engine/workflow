package com.workflow.engine.process.domain.eo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
* @desc wf_runtime_variable
* @author admin
*/
@TableName("wf_runtime_variable")
@Data
public class WfRuntimeVariable{

    @TableId
    @TableField(value = "`id`")
    private Long  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`type`")
    private String type;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`execution_id`")
    private Long  executionId;
    @TableField(value = "`proc_inst_id`")
    private Long  procInstId;
    @TableField(value = "`task_id`")
    private Long  taskId;
    @TableField(value = "`scope_id`")
    private String scopeId;
    @TableField(value = "`sub_scope_id`")
    private String subScopeId;
    @TableField(value = "`scope_type`")
    private String scopeType;
    @TableField(value = "`bytearray_id`")
    private String bytearrayId;
    @TableField(value = "`double_type`")
    private Integer  doubleType;
    @TableField(value = "`long_type`")
    private Integer  longType;
    @TableField(value = "`text`")
    private String text;
    @TableField(value = "`text2`")
    private String text2;

}


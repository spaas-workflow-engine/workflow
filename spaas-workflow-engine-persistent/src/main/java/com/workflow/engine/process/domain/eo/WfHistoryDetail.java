package com.workflow.engine.process.domain.eo;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


/**
* @desc wf_history_detail
* @author admin
*/
@Data
@TableName("wf_history_detail")
public class WfHistoryDetail{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;

    @TableField(value = "`type`")
    private String type;

    @TableField(value = "`proc_inst_id`")
    private String procInstId;

    @TableField(value = "`execution_id`")
    private String executionId;

    @TableField(value = "`task_id`")
    private String taskId;

    @TableField(value = "`act_inst_id`")
    private String actInstId;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "`var_type`")
    private String varType;

    @TableField(value = "`rev`")
    private Integer  rev;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`time`")
    private Date time;

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

    @TableField(value = "`tenant_id`")
    private String tenantId;
}


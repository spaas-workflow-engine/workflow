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
* @desc wf_runtime_wfinst
* @author admin
*/
@TableName("wf_runtime_wfinst")
@Data
public class WfRuntimeWfinst{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`proc_def_id`")
    private Integer  procDefId;
    @TableField(value = "`proc_inst_id`")
    private Integer  procInstId;
    @TableField(value = "`execution_id`")
    private Integer  executionId;
    @TableField(value = "`wf_id`")
    private Integer  wfId;
    @TableField(value = "`task_id`")
    private Integer  taskId;
    @TableField(value = "`call_proc_inst_id`")
    private Integer  callProcInstId;
    @TableField(value = "`wf_name`")
    private String wfName;
    @TableField(value = "`wf_type`")
    private String wfType;
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

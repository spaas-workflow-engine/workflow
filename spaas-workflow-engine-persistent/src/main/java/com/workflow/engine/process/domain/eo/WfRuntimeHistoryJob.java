package com.workflow.engine.process.domain.eo;


import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


/**
* @desc wf_runtime_history_job
* @author admin
*/
@Data
@TableName("wf_runtime_historyjob")
public class WfRuntimeHistoryJob{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`lock_exp_time`")
    private Date lockExpTime;
    @TableField(value = "`lock_owner`")
    private String lockOwner;
    @TableField(value = "`retries`")
    private Integer  retries;
    @TableField(value = "`exception_stack_id`")
    private Integer  exceptionStackId;
    @TableField(value = "`exception_msg`")
    private String exceptionMsg;
    @TableField(value = "`handler_type`")
    private String handlerType;
    @TableField(value = "`handler_cfg`")
    private String handlerCfg;
    @TableField(value = "`custom_values_id`")
    private String customValuesId;
    @TableField(value = "`adv_handler_cfg_id`")
    private String advHandlerCfgId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`create_time`")
    private Date createTime;
    @TableField(value = "`scope_type`")
    private String scopeType;
    @TableField(value = "`tenant_id`")
    private String tenantId;

}


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
* @desc wf_runtime_execution
* @author admin
*/
@Data
@TableName("wf_runtime_execution")
public class WfRuntimeExecution{

    @TableField(value = "`business_key`")
    private String businessKey;
    @TableField(value = "`parent_id`")
    private Integer  parentId;
    @TableField(value = "`proc_def_id`")
    private Long procDefId;
    @TableField(value = "`super_exec`")
    private String superExec;
    @TableField(value = "`root_proc_inst_id`")
    private String rootProcInstId;
    @TableField(value = "`wf_id`")
    private String wfId;
    @TableField(value = "`is_wfive`")
    private Boolean isWfive;
    @TableField(value = "`is_concurrent`")
    private Boolean isConcurrent;
    @TableField(value = "`is_scope`")
    private Boolean isScope;
    @TableField(value = "`is_event_scope`")
    private Boolean isEventScope;
    @TableField(value = "`is_mi_root`")
    private Boolean isMiRoot;
    @TableField(value = "`suspension_state`")
    private Boolean suspensionState;
    @TableField(value = "`cached_ent_state`")
    private Integer  cachedEntState;
    @TableField(value = "`tenant_id`")
    private String tenantId;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`start_wf_id`")
    private String startWfId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`start_time`")
    private Date startTime;
    @TableField(value = "`start_user_id`")
    private String startUserId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`lock_time`")
    private Date lockTime;
    @TableField(value = "`is_count_enabled`")
    private Boolean isCountEnabled;
    @TableField(value = "`evt_subscr_count`")
    private Integer  evtSubscrCount;
    @TableField(value = "`task_count`")
    private Integer  taskCount;
    @TableField(value = "`job_count`")
    private Integer  jobCount;
    @TableField(value = "`timer_job_count`")
    private Integer  timerJobCount;
    @TableField(value = "`susp_job_count`")
    private Integer  suspJobCount;
    @TableField(value = "`deadletter_job_count`")
    private Integer  deadletterJobCount;
    @TableField(value = "`var_count`")
    private Integer  varCount;
    @TableField(value = "`id_link_count`")
    private Integer  idLinkCount;
    @TableField(value = "`callback_id`")
    private String callbackId;
    @TableField(value = "`callback_type`")
    private String callbackType;
    @TableId
    @TableField(value = "`id`")
    private Long  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`proc_inst_id`")
    private Long  procInstId;

}


package com.workflow.engine.domain.eo;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


/**
* @desc wf_history_identitylink
* @author admin
*/
@Data
@TableName("wf_history_identitylink")
public class WfHistoryIdentitylink{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`group_id`")
    private String groupId;
    @TableField(value = "`type`")
    private String type;
    @TableField(value = "`user_id`")
    private String userId;
    @TableField(value = "`task_id`")
    private String taskId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`create_time`")
    private Date createTime;
    @TableField(value = "`proc_inst_id`")
    private String procInstId;
    @TableField(value = "`scope_id`")
    private String scopeId;
    @TableField(value = "`scope_type`")
    private String scopeType;
    @TableField(value = "`scope_definition_id`")
    private String scopeDefinitionId;
    @TableField(value = "`tenant_id`")
    private String tenantId;
}


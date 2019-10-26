package com.workflow.engine.domain.eo;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
* @desc wf_history_attachment
* @author admin
*/
@Data
@TableName("wf_history_attachment")
public class WfHistoryAttachment{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`user_id`")
    private String userId;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`description`")
    private String description;
    @TableField(value = "`type`")
    private String type;
    @TableField(value = "`task_id`")
    private String taskId;
    @TableField(value = "`proc_inst_id`")
    private String procInstId;
    @TableField(value = "`url`")
    private String url;
    @TableField(value = "`content_id`")
    private String contentId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`time`")
    private Date time;
    @TableField(value = "`tenant_id`")
    private String tenantId;
}


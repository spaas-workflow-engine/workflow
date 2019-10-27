package com.workflow.engine.process.domain.eo;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
* @desc wf_history_comment
* @author admin
*/
@Data
@TableName("wf_history_comment")
public class WfHistoryComment{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;

    @TableField(value = "`type`")
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`time`")
    private Date time;

    @TableField(value = "`user_id`")
    private String userId;

    @TableField(value = "`task_id`")
    private String taskId;

    @TableField(value = "`proc_inst_id`")
    private String procInstId;

    @TableField(value = "`action`")
    private String action;

    @TableField(value = "`message`")
    private String message;

    @TableField(value = "`full_msg`")
    private String fullMsg;

    @TableField(value = "`tenant_id`")
    private String tenantId;

}


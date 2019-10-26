package com.workflow.engine.domain.vo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
* @desc wf_history_comment
* @author admin
*/
@Data
public class WfHistoryCommentVO {

    @TableId
    private Integer  id;
    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String userId;
    private String taskId;
    private String procInstId;
    private String action;
    private String message;
    private String fullMsg;
    private String tenantId;

}


package com.workflow.engine.process.domain.vo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
* @desc wf_history_detail
* @author admin
*/
@Data
public class WfHistoryDetailVO {

    @TableId
    private Integer  id;
    private String type;
    private String procInstId;
    private String executionId;
    private String taskId;
    private String actInstId;
    private String name;
    private String varType;
    private Integer  rev;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String bytearrayId;
    private Integer  doubleParam;
    private Integer  longParam;
    private String text;
    private String text2;
    private String tenantId;
}


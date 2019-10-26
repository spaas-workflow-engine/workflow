package com.workflow.engine.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
* @desc wf_history_attachment
* @author admin
*/
@Data
public class WfHistoryAttachmentDTO {

    private Integer  id;
    private Integer  rev;
    private String userId;
    private String name;
    private String description;
    private String type;
    private String taskId;
    private String procInstId;
    private String url;
    private String contentId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String tenantId;
}


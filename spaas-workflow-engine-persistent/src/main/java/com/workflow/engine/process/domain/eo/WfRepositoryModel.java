package com.workflow.engine.process.domain.eo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
* @desc wf_resource_model
* @author admin
*/
@TableName("wf_repository_model")
@Data
public class WfRepositoryModel {

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`code`")
    private String code;
    @TableField(value = "`category`")
    private String category;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`create_time`")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`last_update_time`")
    private Date lastUpdateTime;
    @TableField(value = "`version`")
    private Integer  version;
    @TableField(value = "`meta_info`")
    private String metaInfo;
    @TableField(value = "`deployment_id`")
    private String deploymentId;
    @TableField(value = "`editor_source_value_id`")
    private String editorSourceValueId;
    @TableField(value = "`editor_source_extra_value_id`")
    private String editorSourceExtraValueId;
    @TableField(value = "`tenant_id`")
    private String tenantId;

}


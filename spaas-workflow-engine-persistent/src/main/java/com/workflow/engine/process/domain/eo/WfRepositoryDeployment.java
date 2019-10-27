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
* @desc wf_resource_deployment
* @author admin
*/
@TableName("wf_repository_deployment")
@Data
public class WfRepositoryDeployment {

    @TableId
    @TableField(value = "`id`")
    private Long  id;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`category`")
    private String category;
    @TableField(value = "`code`")
    private String code;
    @TableField(value = "`tenant_id`")
    private String tenantId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`deploy_time`")
    private Date deployTime;
    @TableField(value = "`derived_from`")
    private String derivedFrom;
    @TableField(value = "`derived_from_root`")
    private String derivedFromRoot;
    @TableField(value = "`parent_deployment_id`")
    private String parentDeploymentId;
    @TableField(value = "`engine_version`")
    private String engineVersion;
}


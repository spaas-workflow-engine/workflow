package com.workflow.engine.process.domain.eo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
* @desc wf_resource_procdef
* @author admin
*/
@Data
@TableName("wf_repository_procdef")
public class WfRepositoryProcdef {

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`category`")
    private String category;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`code`")
    private String code;
    @TableField(value = "`version`")
    private Integer  version;
    @TableField(value = "`deployment_id`")
    private String deploymentId;
    @TableField(value = "`resource_name`")
    private String resourceName;
    @TableField(value = "`dgrm_resource_name`")
    private String dgrmResourceName;
    @TableField(value = "`description`")
    private String description;
    @TableField(value = "`has_start_form_key`")
    private Boolean hasStartFormKey;
    @TableField(value = "`has_graphical_notation`")
    private Boolean hasGraphicalNotation;
    @TableField(value = "`suspension_state`")
    private Boolean suspensionState;
    @TableField(value = "`tenant_id`")
    private String tenantId;
    @TableField(value = "`derived_from`")
    private String derivedFrom;
    @TableField(value = "`derived_from_root`")
    private String derivedFromRoot;
    @TableField(value = "`derived_version`")
    private Integer  derivedVersion;
    @TableField(value = "`engine_version`")
    private String engineVersion;

}


package com.workflow.engine.process.domain.eo;


import java.util.Date;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Collection;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
* @desc wf_runtime_entitylink
* @author admin
*/
@TableName("wf_runtime_entitylink")
@Data
public class WfRuntimeEntitylink{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "`create_time`")
    private Date createTime;
    @TableField(value = "`link_type`")
    private String linkType;
    @TableField(value = "`scope_id`")
    private String scopeId;
    @TableField(value = "`scope_type`")
    private String scopeType;
    @TableField(value = "`scope_definition_id`")
    private String scopeDefinitionId;
    @TableField(value = "`ref_scope_id`")
    private String refScopeId;
    @TableField(value = "`ref_scope_type`")
    private String refScopeType;
    @TableField(value = "`ref_scope_definition_id`")
    private String refScopeDefinitionId;
    @TableField(value = "`hierarchy_type`")
    private String hierarchyType;

}


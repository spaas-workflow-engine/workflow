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
* @desc wf_ge_bytearray
* @author admin
*/
@TableName("wf_ge_bytearray")
@Data
public class WfGeBytearray{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`deployment_id`")
    private Integer  deploymentId;
    @TableField(value = "`bytes`")
    private String bytes;
    @TableField(value = "`prototype`")
    private Boolean prototype;

}


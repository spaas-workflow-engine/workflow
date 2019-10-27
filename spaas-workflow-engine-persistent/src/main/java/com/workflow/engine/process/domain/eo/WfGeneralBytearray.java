package com.workflow.engine.process.domain.eo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* @desc wf_ge_bytearray
* @author admin
*/
@TableName("wf_ge_bytearray")
@Data
public class WfGeneralBytearray {

    @TableId
    @TableField(value = "`id`")
    private Long  id;
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


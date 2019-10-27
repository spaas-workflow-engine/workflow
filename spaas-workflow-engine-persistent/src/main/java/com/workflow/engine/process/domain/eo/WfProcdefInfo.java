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
* @desc wf_procdef_info
* @author admin
*/
@TableName("wf_procdef_info")
@Data
public class WfProcdefInfo{

    @TableId
    @TableField(value = "`id`")
    private Integer  id;
    @TableField(value = "`proc_def_id`")
    private Integer  procDefId;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`info_json_id`")
    private Integer  infoJsonId;

}


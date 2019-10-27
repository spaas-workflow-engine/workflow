package com.workflow.engine.process.domain.eo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
* @desc wf_procdef_info
* @author admin
*/
@TableName("wf_procdef_info")
@Data
public class WfProcdefInfo{

    @TableId
    @TableField(value = "`id`")
    private Long  id;
    @TableField(value = "`proc_def_id`")
    private Long  procDefId;
    @TableField(value = "`rev`")
    private Integer  rev;
    @TableField(value = "`info_json_id`")
    private Integer  infoJsonId;

}


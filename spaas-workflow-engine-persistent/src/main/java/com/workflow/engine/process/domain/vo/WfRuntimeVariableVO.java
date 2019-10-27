package com.workflow.engine.process.domain.vo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
* @desc wf_runtime_variable
* @author admin
*/
@TableName("wf_runtime_variable")
@Data
public class WfRuntimeVariableVO {

    private Long  id;
    private Integer  rev;
    private String type;
    private String name;
    private Long  executionId;
    private Long  procInstId;
    private Long  taskId;
    private String scopeId;
    private String subScopeId;
    private String scopeType;
    private String bytearrayId;
    private Integer  doubleType;
    private Integer  longType;
    private String text;
    private String text2;

}


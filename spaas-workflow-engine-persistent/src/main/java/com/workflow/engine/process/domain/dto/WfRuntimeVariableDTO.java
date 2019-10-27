package com.workflow.engine.process.domain.dto;


import lombok.Data;


/**
* @desc wf_runtime_variable
* @author admin
*/
@Data
public class WfRuntimeVariableDTO {
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


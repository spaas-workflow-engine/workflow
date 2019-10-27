package com.workflow.engine.process.domain.dto;

import lombok.Data;

/**
* @desc wf_resource_procdef
* @author admin
*/
@Data
public class WfResourceProcdefDTO {
    private Integer  id;
    private Integer  rev;
    private String category;
    private String name;
    private String code;
    private Integer  version;
    private String deploymentId;
    private String resourceName;
    private String dgrmResourceName;
    private String description;
    private Boolean hasStartFormKey;
    private Boolean hasGraphicalNotation;
    private Boolean suspensionState;
    private String tenantId;
    private String derivedFrom;
    private String derivedFromRoot;
    private Integer  derivedVersion;
    private String engineVersion;

}

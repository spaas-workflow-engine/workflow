package com.workflow.engine.process.domain.vo;


import lombok.Data;

import java.util.Date;


/**
* @desc wf_resource_deployment
* @author admin
*/
@Data
public class WfRepositoryDeploymentVO {

    private Long  id;
    private String name;
    private String category;
    private String code;
    private String tenantId;
    private Date deployTime;
    private String derivedFrom;
    private String derivedFromRoot;
    private String parentDeploymentId;
    private String engineVersion;
}


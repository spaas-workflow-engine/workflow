package com.workflow.engine.process.domain.dto;


import lombok.Data;


/**
* @desc wf_procdef_info
* @author admin
*/
@Data
public class WfProcdefInfoDTO {


    private Long  id;
    private Integer  procDefId;
    private Integer  rev;
    private Integer  infoJsonId;
}


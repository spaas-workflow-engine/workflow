package com.workflow.engine.process.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workflow.engine.process.dao.WfRuntimeExecutionDAO;
import com.workflow.engine.process.domain.eo.WfRuntimeExecution;
import com.workflow.engine.process.mapper.WfRuntimeExecutionMapper;
import org.springframework.stereotype.Repository;


/**
* @desc wf_runtime_execution
* @author admin
*/
@Repository
public class WfRuntimeExecutionDAOImpl extends ServiceImpl<WfRuntimeExecutionMapper, WfRuntimeExecution> implements WfRuntimeExecutionDAO {

}



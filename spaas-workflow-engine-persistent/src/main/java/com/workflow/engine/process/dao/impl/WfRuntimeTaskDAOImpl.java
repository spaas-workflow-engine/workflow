package com.workflow.engine.process.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workflow.engine.process.dao.WfRuntimeTaskDAO;
import com.workflow.engine.process.domain.eo.WfRuntimeTask;
import com.workflow.engine.process.mapper.WfRuntimeTaskMapper;
import org.springframework.stereotype.Repository;


/**
* @desc wf_runtime_task
* @author admin
*/
@Repository
public class WfRuntimeTaskDAOImpl extends ServiceImpl<WfRuntimeTaskMapper, WfRuntimeTask> implements WfRuntimeTaskDAO {

}


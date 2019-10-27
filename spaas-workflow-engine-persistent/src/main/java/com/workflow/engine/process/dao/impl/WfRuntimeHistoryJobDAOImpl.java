package com.workflow.engine.process.dao.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workflow.engine.process.dao.WfRuntimeHistoryJobDAO;
import com.workflow.engine.process.domain.eo.WfRuntimeHistoryJob;
import com.workflow.engine.process.mapper.WfRuntimeHistoryJobMapper;
import org.springframework.stereotype.Repository;


/**
* @desc wf_runtime_history_job
* @author admin
*/
@Repository
public class WfRuntimeHistoryJobDAOImpl extends ServiceImpl<WfRuntimeHistoryJobMapper, WfRuntimeHistoryJob> implements WfRuntimeHistoryJobDAO {

}




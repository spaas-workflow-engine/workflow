package com.workflow.engine.process.dao.impl;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workflow.engine.process.dao.WfRuntimeVariableDAO;
import com.workflow.engine.process.domain.eo.WfRuntimeVariable;
import com.workflow.engine.process.mapper.WfRuntimeVariableMapper;
import lombok.Data;


/**
* @desc wf_runtime_variable
* @author admin
*/
@TableName("wf_runtime_variable")
@Data
public class WfRuntimeVariableDAOImpl extends ServiceImpl<WfRuntimeVariableMapper, WfRuntimeVariable> implements WfRuntimeVariableDAO {

}



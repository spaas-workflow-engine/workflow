package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeExecution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeExecutionMapper extends BaseMapper<WfRuntimeExecution> {

    List<WfRuntimeExecution> findList(@Param("eo") WfRuntimeExecution eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
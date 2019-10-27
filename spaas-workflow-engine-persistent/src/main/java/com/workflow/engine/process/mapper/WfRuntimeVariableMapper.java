package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeVariable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeVariableMapper extends BaseMapper<WfRuntimeVariable> {

    List<WfRuntimeVariable> findList(@Param("eo") WfRuntimeVariable eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
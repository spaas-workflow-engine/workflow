package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeTaskMapper extends BaseMapper<WfRuntimeTask> {

    List<WfRuntimeTask> findList(@Param("eo") WfRuntimeTask eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
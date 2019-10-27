package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeTimerJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeTimerJobMapper extends BaseMapper<WfRuntimeTimerJob> {

    List<WfRuntimeTimerJob> findList(@Param("eo") WfRuntimeTimerJob eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
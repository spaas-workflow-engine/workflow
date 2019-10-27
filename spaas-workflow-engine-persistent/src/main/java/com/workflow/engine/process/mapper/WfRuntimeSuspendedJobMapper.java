package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeSuspendedJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeSuspendedJobMapper extends BaseMapper<WfRuntimeSuspendedJob> {

    List<WfRuntimeSuspendedJob> findList(@Param("eo") WfRuntimeSuspendedJob eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
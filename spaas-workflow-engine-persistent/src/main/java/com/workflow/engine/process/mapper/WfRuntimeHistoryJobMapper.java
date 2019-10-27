package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeHistoryJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeHistoryJobMapper extends BaseMapper<WfRuntimeHistoryJob> {

    List<WfRuntimeHistoryJob> findList(@Param("eo") WfRuntimeHistoryJob eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
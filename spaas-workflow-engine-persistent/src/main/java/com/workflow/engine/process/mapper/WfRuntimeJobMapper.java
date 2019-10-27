package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeJobMapper extends BaseMapper<WfRuntimeJob> {

    List<WfRuntimeJob> findList(@Param("eo") WfRuntimeJob eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
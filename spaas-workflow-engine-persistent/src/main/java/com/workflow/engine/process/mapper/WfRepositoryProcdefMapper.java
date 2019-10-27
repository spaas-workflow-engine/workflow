package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRepositoryProcdef;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface WfRepositoryProcdefMapper extends BaseMapper<WfRepositoryProcdef> {

    List<WfRepositoryProcdef> findList(@Param("eo") WfRepositoryProcdef eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
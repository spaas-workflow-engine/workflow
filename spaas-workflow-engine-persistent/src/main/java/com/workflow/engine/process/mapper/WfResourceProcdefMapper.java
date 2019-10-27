package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfResourceProcdef;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfResourceProcdefMapper extends BaseMapper<WfResourceProcdef> {

    List<WfResourceProcdef> findList(@Param("eo") WfResourceProcdef eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
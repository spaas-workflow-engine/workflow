package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeEventSubscr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeEventSubscrMapper extends BaseMapper<WfRuntimeEventSubscr> {

    List<WfRuntimeEventSubscr> findList(@Param("eo") WfRuntimeEventSubscr eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
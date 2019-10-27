package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeEntitylink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeEntitylinkMapper extends BaseMapper<WfRuntimeEntitylink> {

    List<WfRuntimeEntitylink> findList(@Param("eo") WfRuntimeEntitylink eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
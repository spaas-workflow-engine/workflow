package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfProcdefInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfProcdefInfoMapper extends BaseMapper<WfProcdefInfo> {

    List<WfProcdefInfo> findList(@Param("eo") WfProcdefInfo eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
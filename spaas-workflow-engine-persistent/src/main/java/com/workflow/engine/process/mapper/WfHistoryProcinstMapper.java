package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfHistoryProcinst;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfHistoryProcinstMapper extends BaseMapper<WfHistoryProcinst> {

    List<WfHistoryProcinst> findList(@Param("eo") WfHistoryProcinst eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
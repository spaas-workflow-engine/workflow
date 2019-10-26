package com.workflow.engine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.domain.eo.WfHistoryTaskinst;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfHistoryTaskinstMapper extends BaseMapper<WfHistoryTaskinst> {

    List<WfHistoryTaskinst> findList(@Param("eo") WfHistoryTaskinst eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
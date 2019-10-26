package com.workflow.engine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.domain.eo.WfHistoryVarinst;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfHistoryVarinstMapper extends BaseMapper<WfHistoryVarinst> {

    List<WfHistoryVarinst> findList(@Param("eo") WfHistoryVarinst eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
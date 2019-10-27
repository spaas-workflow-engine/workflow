package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfHistoryActinst;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfHistoryActinstMapper extends BaseMapper<WfHistoryActinst> {

    List<WfHistoryActinst> findList(@Param("eo") WfHistoryActinst eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
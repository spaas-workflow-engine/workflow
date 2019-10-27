package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfHistoryDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfHistoryDetailMapper extends BaseMapper<WfHistoryDetail> {

    List<WfHistoryDetail> findList(@Param("eo") WfHistoryDetail eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
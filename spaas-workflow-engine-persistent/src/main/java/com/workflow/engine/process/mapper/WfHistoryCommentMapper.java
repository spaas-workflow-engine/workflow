package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfHistoryComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfHistoryCommentMapper extends BaseMapper<WfHistoryComment> {

    List<WfHistoryComment> findList(@Param("eo") WfHistoryComment eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
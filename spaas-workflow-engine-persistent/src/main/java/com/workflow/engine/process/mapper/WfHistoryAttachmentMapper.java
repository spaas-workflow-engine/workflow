package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfHistoryAttachment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfHistoryAttachmentMapper extends BaseMapper<WfHistoryAttachment> {

    List<WfHistoryAttachment> findList(@Param("eo") WfHistoryAttachment eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
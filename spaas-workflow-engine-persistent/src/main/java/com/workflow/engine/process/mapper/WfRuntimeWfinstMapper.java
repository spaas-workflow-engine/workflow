package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRuntimeWfinst;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfRuntimeWfinstMapper extends BaseMapper<WfRuntimeWfinst> {

    List<WfRuntimeWfinst> findList(@Param("eo") WfRuntimeWfinst eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfGeBytearray;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfGeBytearrayMapper extends BaseMapper<WfGeBytearray> {

    List<WfGeBytearray> findList(@Param("eo") WfGeBytearray eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
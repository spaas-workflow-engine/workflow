package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfGeneralBytearray;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface WfGeneralBytearrayMapper extends BaseMapper<WfGeneralBytearray> {

    List<WfGeneralBytearray> findList(@Param("eo") WfGeneralBytearray eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
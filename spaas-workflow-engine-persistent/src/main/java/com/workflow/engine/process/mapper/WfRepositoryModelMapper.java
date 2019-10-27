package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRepositoryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface WfRepositoryModelMapper extends BaseMapper<WfRepositoryModel> {

    List<WfRepositoryModel> findList(@Param("eo") WfRepositoryModel eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
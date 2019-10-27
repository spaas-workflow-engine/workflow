package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfRepositoryDeployment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface WfRepositoryDeploymentMapper extends BaseMapper<WfRepositoryDeployment> {

    List<WfRepositoryDeployment> findList(@Param("eo") WfRepositoryDeployment eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
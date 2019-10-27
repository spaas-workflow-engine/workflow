package com.workflow.engine.process.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.engine.process.domain.eo.WfHistoryIdentitylink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface  WfHistoryIdentitylinkMapper extends BaseMapper<WfHistoryIdentitylink> {

    List<WfHistoryIdentitylink> findList(@Param("eo") WfHistoryIdentitylink eo);

    int deleteByIds(@Param("ids") List<Integer> ids);

}
package com.workflow.engine.process.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workflow.engine.process.dao.WfHistoryDetailDAO;
import com.workflow.engine.process.domain.eo.WfHistoryDetail;
import com.workflow.engine.process.mapper.WfHistoryDetailMapper;
import org.springframework.stereotype.Service;


@Service
public class WfHistoryDetailDAOImpl extends ServiceImpl<WfHistoryDetailMapper, WfHistoryDetail>  implements WfHistoryDetailDAO {



}

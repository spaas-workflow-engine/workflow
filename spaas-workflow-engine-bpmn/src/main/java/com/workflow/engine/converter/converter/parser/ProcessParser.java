package com.workflow.engine.converter.converter.parser;
import cn.hutool.core.util.StrUtil;
import com.workflow.engine.converter.constants.BpmnXMLConstants;
import com.workflow.engine.converter.converter.export.ProcessExport;
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.Process;

import javax.xml.stream.XMLStreamReader;
import java.util.List;

/**
 * @author Tijs Rademakers
 */
public class ProcessParser implements BpmnXMLConstants {

    public Process parse(XMLStreamReader xtr, BpmnModel model) throws Exception {
        Process process = null;
        if (StrUtil.isNotEmpty(xtr.getAttributeValue(null, ATTRIBUTE_ID))) {
            String processId = xtr.getAttributeValue(null, ATTRIBUTE_ID);
            process = new Process();
            process.setId(processId);
            BpmnXMLUtil.addXMLLocation(process, xtr);
            process.setName(xtr.getAttributeValue(null, ATTRIBUTE_NAME));
            if (StrUtil.isNotEmpty(xtr.getAttributeValue(null, ATTRIBUTE_PROCESS_EXECUTABLE))) {
                process.setExecutable(Boolean.parseBoolean(xtr.getAttributeValue(null, ATTRIBUTE_PROCESS_EXECUTABLE)));
            }

            String candidateUsersString = BpmnXMLUtil.getAttributeValue(ATTRIBUTE_PROCESS_CANDIDATE_USERS, xtr);
            if (StrUtil.isNotEmpty(candidateUsersString)) {
                List<String> candidateUsers = BpmnXMLUtil.parseDelimitedList(candidateUsersString);
                process.setCandidateStarterUsers(candidateUsers);
            }

            String candidateGroupsString = BpmnXMLUtil.getAttributeValue(ATTRIBUTE_PROCESS_CANDIDATE_GROUPS, xtr);
            if (StrUtil.isNotEmpty(candidateGroupsString)) {
                List<String> candidateGroups = BpmnXMLUtil.parseDelimitedList(candidateGroupsString);
                process.setCandidateStarterGroups(candidateGroups);
            }
            
            if (StrUtil.isNotEmpty(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_PROCESS_EAGER_EXECUTION_FETCHING, xtr))) {
                process.setEnableEagerExecutionTreeFetching(
                        Boolean.parseBoolean(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_PROCESS_EAGER_EXECUTION_FETCHING, xtr)));
            }
            
            BpmnXMLUtil.addCustomAttributes(xtr, process, ProcessExport.defaultProcessAttributes);

            model.getProcesses().add(process);

        }
        return process;
    }
}

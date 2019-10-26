/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.workflow.engine.converter.converter;


import cn.hutool.core.util.StrUtil;
import com.workflow.engine.converter.converter.child.BaseChildElementParser;
import com.workflow.engine.converter.converter.child.InParameterParser;
import com.workflow.engine.converter.converter.child.OutParameterParser;
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.BaseElement;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.CaseServiceTask;
import com.workflow.engine.model.ServiceTask;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.HashMap;
import java.util.Map;
import static com.workflow.engine.converter.constants.BpmnXMLConstants.*;

/**
 * @author Tijs Rademakers
 */
public class CaseServiceTaskXMLConverter extends ServiceTaskXMLConverter {
    
    protected Map<String, BaseChildElementParser> childParserMap = new HashMap<>();
    
    public CaseServiceTaskXMLConverter() {
        InParameterParser inParameterParser = new InParameterParser();
        childParserMap.put(inParameterParser.getElementName(), inParameterParser);
        OutParameterParser outParameterParser = new OutParameterParser();
        childParserMap.put(outParameterParser.getElementName(), outParameterParser);
    }

    @Override
    public Class<? extends BaseElement> getBpmnElementType() {
        return CaseServiceTask.class;
    }

    @Override
    protected void convertCaseServiceTaskXMLProperties(CaseServiceTask caseServiceTask, BpmnModel bpmnModel, XMLStreamReader xtr) throws Exception {
        String caseDefinitionKey = BpmnXMLUtil.getAttributeValue(ATTRIBUTE_CASE_TASK_CASE_DEFINITION_KEY, xtr);
        if (StrUtil.isNotEmpty(caseDefinitionKey)) {
            caseServiceTask.setCaseDefinitionKey(caseDefinitionKey);
        }
        
        String caseInstanceName = BpmnXMLUtil.getAttributeValue(ATTRIBUTE_CASE_TASK_CASE_INSTANCE_NAME, xtr);
        if (StrUtil.isNotEmpty(caseInstanceName)) {
            caseServiceTask.setCaseInstanceName(caseInstanceName);
        }
        
        caseServiceTask.setBusinessKey(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_BUSINESS_KEY, xtr));
        caseServiceTask.setInheritBusinessKey(Boolean.parseBoolean(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_INHERIT_BUSINESS_KEY, xtr)));
        caseServiceTask.setSameDeployment(Boolean.valueOf(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_SAME_DEPLOYMENT, xtr)));
        caseServiceTask.setFallbackToDefaultTenant(Boolean.valueOf(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_FALLBACK_TO_DEFAULT_TENANT, xtr)));
        caseServiceTask.setCaseInstanceIdVariableName(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_ID_VARIABLE_NAME, xtr));
        parseChildElements(getXMLElementName(), caseServiceTask, childParserMap, bpmnModel, xtr);
    }
    
    @Override
    protected void writeAdditionalAttributes(BaseElement element, BpmnModel model, XMLStreamWriter xtw) throws Exception {
        CaseServiceTask caseServiceTask = (CaseServiceTask) element;
        writeQualifiedAttribute(ATTRIBUTE_TYPE, ServiceTask.CASE_TASK, xtw);
        
        if (StrUtil.isNotEmpty(caseServiceTask.getSkipExpression())) {
            writeQualifiedAttribute(ATTRIBUTE_TASK_SERVICE_SKIP_EXPRESSION, caseServiceTask.getSkipExpression(), xtw);
        }
        if (StrUtil.isNotEmpty(caseServiceTask.getCaseDefinitionKey())) {
            writeQualifiedAttribute(ATTRIBUTE_CASE_TASK_CASE_DEFINITION_KEY, caseServiceTask.getCaseDefinitionKey(), xtw);
        }
        if (StrUtil.isNotEmpty(caseServiceTask.getCaseInstanceName())) {
            writeQualifiedAttribute(ATTRIBUTE_CASE_TASK_CASE_INSTANCE_NAME, caseServiceTask.getCaseInstanceName(), xtw);
        }
        if (StrUtil.isNotEmpty(caseServiceTask.getBusinessKey())) {
            writeQualifiedAttribute(ATTRIBUTE_BUSINESS_KEY, caseServiceTask.getBusinessKey(), xtw);
        }
        if (caseServiceTask.isInheritBusinessKey()) {
            writeQualifiedAttribute(ATTRIBUTE_INHERIT_BUSINESS_KEY, "true", xtw);
        }
        if (caseServiceTask.isSameDeployment()) {
            writeQualifiedAttribute(ATTRIBUTE_SAME_DEPLOYMENT, "true", xtw);
        }
        if (caseServiceTask.isFallbackToDefaultTenant()) {
            writeQualifiedAttribute(ATTRIBUTE_FALLBACK_TO_DEFAULT_TENANT, "true", xtw);
        }
        if (StrUtil.isNotEmpty(caseServiceTask.getCaseInstanceIdVariableName())) {
            writeQualifiedAttribute(ATTRIBUTE_ID_VARIABLE_NAME, caseServiceTask.getCaseInstanceIdVariableName(), xtw);
        }
    }

    @Override
    protected boolean writeExtensionChildElements(BaseElement element, boolean didWriteExtensionStartElement, XMLStreamWriter xtw) throws Exception {
        CaseServiceTask caseServiceTask = (CaseServiceTask) element;
        didWriteExtensionStartElement = BpmnXMLUtil.writeIOParameters(ELEMENT_IN_PARAMETERS, caseServiceTask.getInParameters(), didWriteExtensionStartElement, xtw);
        didWriteExtensionStartElement = BpmnXMLUtil.writeIOParameters(ELEMENT_OUT_PARAMETERS, caseServiceTask.getOutParameters(), didWriteExtensionStartElement, xtw);
        return didWriteExtensionStartElement;
    }

    @Override
    protected void writeAdditionalChildElements(BaseElement element, BpmnModel model, XMLStreamWriter xtw) throws Exception {
    }
}

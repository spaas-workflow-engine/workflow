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
import com.workflow.engine.converter.converter.export.FieldExtensionExport;
import com.workflow.engine.converter.converter.export.MapExceptionExport;
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.*;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import static com.workflow.engine.converter.constants.BpmnXMLConstants.*;

/**
 * @author Tijs Rademakers
 */
public class ServiceTaskXMLConverter extends BaseBpmnXMLConverter {

    @Override
    public Class<? extends BaseElement> getBpmnElementType() {
        return ServiceTask.class;
    }

    @Override
    protected String getXMLElementName() {
        return ELEMENT_TASK_SERVICE;
    }

    @Override
    protected BaseElement convertXMLToElement(XMLStreamReader xtr, BpmnModel model) throws Exception {
        String serviceTaskType = BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TYPE, xtr);
        
        ServiceTask serviceTask = null;
        if (ServiceTask.HTTP_TASK.equals(serviceTaskType)) {
            serviceTask = new HttpServiceTask();
            
        } else if (ServiceTask.CASE_TASK.equals(serviceTaskType)) {
            serviceTask = new CaseServiceTask();
            
        } else {
            serviceTask = new ServiceTask();
        }
        
        BpmnXMLUtil.addXMLLocation(serviceTask, xtr);
        if (StrUtil.isNotEmpty(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_CLASS, xtr))) {
            serviceTask.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_CLASS);
            serviceTask.setImplementation(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_CLASS, xtr));

        } else if (StrUtil.isNotEmpty(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_EXPRESSION, xtr))) {
            serviceTask.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_EXPRESSION);
            serviceTask.setImplementation(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_EXPRESSION, xtr));

        } else if (StrUtil.isNotEmpty(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_DELEGATEEXPRESSION, xtr))) {
            serviceTask.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION);
            serviceTask.setImplementation(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_DELEGATEEXPRESSION, xtr));

        } else if ("##WebService".equals(xtr.getAttributeValue(null, ATTRIBUTE_TASK_IMPLEMENTATION))) {
            serviceTask.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_WEBSERVICE);
            serviceTask.setOperationRef(parseOperationRef(xtr.getAttributeValue(null, ATTRIBUTE_TASK_OPERATION_REF), model));
        }

        serviceTask.setResultVariableName(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_RESULTVARIABLE, xtr));
        if (StrUtil.isEmpty(serviceTask.getResultVariableName())) {
            serviceTask.setResultVariableName(BpmnXMLUtil.getAttributeValue("resultVariable", xtr));
        }

        serviceTask.setUseLocalScopeForResultVariable(Boolean.valueOf(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_USE_LOCAL_SCOPE_FOR_RESULT_VARIABLE, xtr)));

        serviceTask.setType(serviceTaskType);
        serviceTask.setExtensionId(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_EXTENSIONID, xtr));

        if (StrUtil.isNotEmpty(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_SKIP_EXPRESSION, xtr))) {
            serviceTask.setSkipExpression(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_TASK_SERVICE_SKIP_EXPRESSION, xtr));
        }
        
        if (serviceTask instanceof CaseServiceTask) {
            convertCaseServiceTaskXMLProperties((CaseServiceTask) serviceTask, model, xtr);
        } else {
            parseChildElements(getXMLElementName(), serviceTask, model, xtr);
        }

        return serviceTask;
    }

    @Override
    protected void writeAdditionalAttributes(BaseElement element, BpmnModel model, XMLStreamWriter xtw) throws Exception {

        ServiceTask serviceTask = (ServiceTask) element;

        if (ImplementationType.IMPLEMENTATION_TYPE_CLASS.equals(serviceTask.getImplementationType())) {
            writeQualifiedAttribute(ATTRIBUTE_TASK_SERVICE_CLASS, serviceTask.getImplementation(), xtw);
        } else if (ImplementationType.IMPLEMENTATION_TYPE_EXPRESSION.equals(serviceTask.getImplementationType())) {
            writeQualifiedAttribute(ATTRIBUTE_TASK_SERVICE_EXPRESSION, serviceTask.getImplementation(), xtw);
        } else if (ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION.equals(serviceTask.getImplementationType())) {
            writeQualifiedAttribute(ATTRIBUTE_TASK_SERVICE_DELEGATEEXPRESSION, serviceTask.getImplementation(), xtw);
        }

        if (StrUtil.isNotEmpty(serviceTask.getResultVariableName())) {
            writeQualifiedAttribute(ATTRIBUTE_TASK_SERVICE_RESULTVARIABLE, serviceTask.getResultVariableName(), xtw);
        }
        if (StrUtil.isNotEmpty(serviceTask.getType())) {
            writeQualifiedAttribute(ATTRIBUTE_TYPE, serviceTask.getType(), xtw);
        }
        if (StrUtil.isNotEmpty(serviceTask.getExtensionId())) {
            writeQualifiedAttribute(ATTRIBUTE_TASK_SERVICE_EXTENSIONID, serviceTask.getExtensionId(), xtw);
        }
        if (StrUtil.isNotEmpty(serviceTask.getSkipExpression())) {
            writeQualifiedAttribute(ATTRIBUTE_TASK_SERVICE_SKIP_EXPRESSION, serviceTask.getSkipExpression(), xtw);
        }
        if (serviceTask.isTriggerable()) {
            writeQualifiedAttribute(ATTRIBUTE_ACTIVITY_TRIGGERABLE, "true", xtw);
        }

        if (serviceTask.isUseLocalScopeForResultVariable()) {
            writeQualifiedAttribute(ATTRIBUTE_TASK_SERVICE_USE_LOCAL_SCOPE_FOR_RESULT_VARIABLE, "true", xtw);
        }
    }

    @Override
    protected boolean writeExtensionChildElements(BaseElement element, boolean didWriteExtensionStartElement, XMLStreamWriter xtw) throws Exception {
        ServiceTask serviceTask = (ServiceTask) element;

        if (!serviceTask.getCustomProperties().isEmpty()) {
            writeCustomProperties(serviceTask, didWriteExtensionStartElement, xtw);
            
        } else {
            if (serviceTask instanceof HttpServiceTask) {
                didWriteExtensionStartElement = writeHttpTaskExtensionElements((HttpServiceTask) serviceTask, didWriteExtensionStartElement, xtw);
            }
            
            didWriteExtensionStartElement = FieldExtensionExport.writeFieldExtensions(serviceTask.getFieldExtensions(), didWriteExtensionStartElement, xtw);
            didWriteExtensionStartElement = MapExceptionExport.writeMapExceptionExtensions(serviceTask.getMapExceptions(), didWriteExtensionStartElement, xtw);
        }

        return didWriteExtensionStartElement;
    }

    @Override
    protected void writeAdditionalChildElements(BaseElement element, BpmnModel model, XMLStreamWriter xtw) throws Exception {
    }
    
    protected void convertCaseServiceTaskXMLProperties(CaseServiceTask caseServiceTask, BpmnModel bpmnModel, XMLStreamReader xtr) throws Exception {
        
    }
    
    protected boolean writeCustomProperties(ServiceTask serviceTask, boolean didWriteExtensionStartElement, XMLStreamWriter xtw) throws Exception {
        for (CustomProperty customProperty : serviceTask.getCustomProperties()) {

            if (StrUtil.isEmpty(customProperty.getSimpleValue())) {
                continue;
            }

            if (!didWriteExtensionStartElement) {
                xtw.writeStartElement(ELEMENT_EXTENSIONS);
                didWriteExtensionStartElement = true;
            }
            xtw.writeStartElement(FLOWABLE_EXTENSIONS_PREFIX, ELEMENT_FIELD, FLOWABLE_EXTENSIONS_NAMESPACE);
            xtw.writeAttribute(ATTRIBUTE_FIELD_NAME, customProperty.getName());
            if ((customProperty.getSimpleValue().contains("${") || customProperty.getSimpleValue().contains("#{")) && customProperty.getSimpleValue().contains("}")) {

                xtw.writeStartElement(FLOWABLE_EXTENSIONS_PREFIX, ATTRIBUTE_FIELD_EXPRESSION, FLOWABLE_EXTENSIONS_NAMESPACE);
            } else {
                xtw.writeStartElement(FLOWABLE_EXTENSIONS_PREFIX, ELEMENT_FIELD_STRING, FLOWABLE_EXTENSIONS_NAMESPACE);
            }
            xtw.writeCharacters(customProperty.getSimpleValue());
            xtw.writeEndElement();
            xtw.writeEndElement();
        }
        
        return didWriteExtensionStartElement;
    }
    
    protected boolean writeHttpTaskExtensionElements(HttpServiceTask httpServiceTask, boolean didWriteExtensionStartElement, XMLStreamWriter xtw) throws Exception {
        if (httpServiceTask.getHttpRequestHandler() != null) {
            if (!didWriteExtensionStartElement) {
                xtw.writeStartElement(ELEMENT_EXTENSIONS);
                didWriteExtensionStartElement = true;
            }
            
            xtw.writeStartElement(FLOWABLE_EXTENSIONS_PREFIX, ELEMENT_HTTP_REQUEST_HANDLER, FLOWABLE_EXTENSIONS_NAMESPACE);
            writeHttpHandlerAttributes(httpServiceTask.getHttpRequestHandler(), xtw);
            xtw.writeEndElement();
        }
        
        if (httpServiceTask.getHttpResponseHandler() != null) {
            if (!didWriteExtensionStartElement) {
                xtw.writeStartElement(ELEMENT_EXTENSIONS);
                didWriteExtensionStartElement = true;
            }
            
            xtw.writeStartElement(FLOWABLE_EXTENSIONS_PREFIX, ELEMENT_HTTP_RESPONSE_HANDLER, FLOWABLE_EXTENSIONS_NAMESPACE);
            writeHttpHandlerAttributes(httpServiceTask.getHttpResponseHandler(), xtw);
            xtw.writeEndElement();
        }
        
        return didWriteExtensionStartElement;
    }

    protected String parseOperationRef(String operationRef, BpmnModel model) {
        String result = null;
        if (StrUtil.isNotEmpty(operationRef)) {
            int indexOfP = operationRef.indexOf(':');
            if (indexOfP != -1) {
                String prefix = operationRef.substring(0, indexOfP);
                String resolvedNamespace = model.getNamespace(prefix);
                result = resolvedNamespace + ":" + operationRef.substring(indexOfP + 1);
            } else {
                result = model.getTargetNamespace() + ":" + operationRef;
            }
        }
        return result;
    }
    
    protected void writeHttpHandlerAttributes(AbstractFlowableHttpHandler httpHandler, XMLStreamWriter xtw) throws Exception {
        if (ImplementationType.IMPLEMENTATION_TYPE_CLASS.equals(httpHandler.getImplementationType())) {
            xtw.writeAttribute(ATTRIBUTE_TASK_SERVICE_CLASS, httpHandler.getImplementation());
        } else if (ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION.equals(httpHandler.getImplementationType())) {
            xtw.writeAttribute(ATTRIBUTE_TASK_SERVICE_DELEGATEEXPRESSION, httpHandler.getImplementation());
        }
    }
}

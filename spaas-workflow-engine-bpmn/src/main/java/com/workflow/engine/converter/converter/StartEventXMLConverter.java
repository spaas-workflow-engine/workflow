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
import com.workflow.engine.converter.constants.BpmnXMLConstants;
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.BaseElement;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.StartEvent;
import com.workflow.engine.model.alfresco.AlfrescoStartEvent;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * @author Tijs Rademakers
 */
public class StartEventXMLConverter extends BaseBpmnXMLConverter {

    @Override
    public Class<? extends BaseElement> getBpmnElementType() {
        return StartEvent.class;
    }

    @Override
    protected String getXMLElementName() {
        return ELEMENT_EVENT_START;
    }

    @Override
    protected BaseElement convertXMLToElement(XMLStreamReader xtr, BpmnModel model) throws Exception {
        String formKey = BpmnXMLUtil.getAttributeValue(ATTRIBUTE_FORM_FORMKEY, xtr);
        StartEvent startEvent = null;
        if (StrUtil.isNotEmpty(formKey)) {
            if (model.getStartEventFormTypes() != null && model.getStartEventFormTypes().contains(formKey)) {
                startEvent = new AlfrescoStartEvent();
            }
        }
        if (startEvent == null) {
            startEvent = new StartEvent();
        }

        BpmnXMLUtil.addXMLLocation(startEvent, xtr);
        startEvent.setInitiator(BpmnXMLUtil.getAttributeValue(ATTRIBUTE_EVENT_START_INITIATOR, xtr));
        boolean interrupting = true;
        String interruptingAttribute = xtr.getAttributeValue(null, ATTRIBUTE_EVENT_START_INTERRUPTING);
        if (ATTRIBUTE_VALUE_FALSE.equalsIgnoreCase(interruptingAttribute)) {
            interrupting = false;
        }

        startEvent.setInterrupting(interrupting);
        startEvent.setFormKey(formKey);
        String formValidation = BpmnXMLUtil.getAttributeValue(BpmnXMLConstants.ATTRIBUTE_FORM_FIELD_VALIDATION, xtr);
        startEvent.setValidateFormFields(formValidation);

        parseChildElements(getXMLElementName(), startEvent, model, xtr);

        return startEvent;
    }

    @Override
    protected void writeAdditionalAttributes(BaseElement element, BpmnModel model, XMLStreamWriter xtw) throws Exception {
        StartEvent startEvent = (StartEvent) element;
        writeQualifiedAttribute(ATTRIBUTE_EVENT_START_INITIATOR, startEvent.getInitiator(), xtw);
        writeQualifiedAttribute(ATTRIBUTE_FORM_FORMKEY, startEvent.getFormKey(), xtw);
        writeQualifiedAttribute(ATTRIBUTE_FORM_FIELD_VALIDATION, startEvent.getValidateFormFields(), xtw);

        if (startEvent.getEventDefinitions() != null && startEvent.getEventDefinitions().size() > 0) {
            writeDefaultAttribute(ATTRIBUTE_EVENT_START_INTERRUPTING, String.valueOf(startEvent.isInterrupting()), xtw);
        }
    }

    @Override
    protected boolean writeExtensionChildElements(BaseElement element, boolean didWriteExtensionStartElement, XMLStreamWriter xtw) throws Exception {
        StartEvent startEvent = (StartEvent) element;
        didWriteExtensionStartElement = writeFormProperties(startEvent, didWriteExtensionStartElement, xtw);
        return didWriteExtensionStartElement;
    }

    @Override
    protected void writeAdditionalChildElements(BaseElement element, BpmnModel model, XMLStreamWriter xtw) throws Exception {
        StartEvent startEvent = (StartEvent) element;
        writeEventDefinitions(startEvent, startEvent.getEventDefinitions(), model, xtw);
    }
}

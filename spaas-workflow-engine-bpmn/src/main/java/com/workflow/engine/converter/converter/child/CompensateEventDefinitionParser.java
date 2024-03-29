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
package com.workflow.engine.converter.converter.child;


import cn.hutool.core.util.StrUtil;
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.BaseElement;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.CompensateEventDefinition;
import com.workflow.engine.model.Event;

import javax.xml.stream.XMLStreamReader;

/**
 * @author Tijs Rademakers
 */
public class CompensateEventDefinitionParser extends BaseChildElementParser {

    @Override
    public String getElementName() {
        return ELEMENT_EVENT_COMPENSATEDEFINITION;
    }

    @Override
    public void parseChildElement(XMLStreamReader xtr, BaseElement parentElement, BpmnModel model) throws Exception {
        if (!(parentElement instanceof Event))
            return;

        CompensateEventDefinition eventDefinition = new CompensateEventDefinition();
        BpmnXMLUtil.addXMLLocation(eventDefinition, xtr);
        eventDefinition.setActivityRef(xtr.getAttributeValue(null, ATTRIBUTE_COMPENSATE_ACTIVITYREF));
        if (StrUtil.isNotEmpty(xtr.getAttributeValue(null, ATTRIBUTE_COMPENSATE_WAITFORCOMPLETION))) {
            eventDefinition.setWaitForCompletion(Boolean.parseBoolean(xtr.getAttributeValue(null, ATTRIBUTE_COMPENSATE_WAITFORCOMPLETION)));
        }

        BpmnXMLUtil.parseChildElements(ELEMENT_EVENT_COMPENSATEDEFINITION, eventDefinition, xtr, model);

        ((Event) parentElement).getEventDefinitions().add(eventDefinition);
    }
}

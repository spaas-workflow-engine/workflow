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
import com.workflow.engine.model.EventListener;
import com.workflow.engine.model.ImplementationType;
import javax.xml.stream.XMLStreamReader;

/**
 * @author Frederik Heremans
 */
public class FlowableEventListenerParser extends BaseChildElementParser {

    @Override
    public void parseChildElement(XMLStreamReader xtr, BaseElement parentElement, BpmnModel model) throws Exception {
        EventListener listener = new EventListener();
        BpmnXMLUtil.addXMLLocation(listener, xtr);

        if (StrUtil.isNotEmpty(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_CLASS))) {
            listener.setImplementation(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_CLASS));
            listener.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_CLASS);
        } else if (StrUtil.isNotEmpty(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_DELEGATEEXPRESSION))) {
            listener.setImplementation(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_DELEGATEEXPRESSION));
            listener.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION);
        } else if (StrUtil.isNotEmpty(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_THROW_EVENT_TYPE))) {
            String eventType = xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_THROW_EVENT_TYPE);
            if (ATTRIBUTE_LISTENER_THROW_EVENT_TYPE_SIGNAL.equals(eventType)) {
                listener.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_THROW_SIGNAL_EVENT);
                listener.setImplementation(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_THROW_SIGNAL_EVENT_NAME));
            } else if (ATTRIBUTE_LISTENER_THROW_EVENT_TYPE_GLOBAL_SIGNAL.equals(eventType)) {
                listener.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_THROW_GLOBAL_SIGNAL_EVENT);
                listener.setImplementation(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_THROW_SIGNAL_EVENT_NAME));
            } else if (ATTRIBUTE_LISTENER_THROW_EVENT_TYPE_MESSAGE.equals(eventType)) {
                listener.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_THROW_MESSAGE_EVENT);
                listener.setImplementation(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_THROW_MESSAGE_EVENT_NAME));
            } else if (ATTRIBUTE_LISTENER_THROW_EVENT_TYPE_ERROR.equals(eventType)) {
                listener.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_THROW_ERROR_EVENT);
                listener.setImplementation(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_THROW_ERROR_EVENT_CODE));
            } else {
                listener.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_INVALID_THROW_EVENT);
            }
        }
        
        listener.setEvents(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_EVENTS));
        listener.setEntityType(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_ENTITY_TYPE));
        
        if (StrUtil.isNotEmpty(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_ON_TRANSACTION))){
            listener.setOnTransaction(xtr.getAttributeValue(null, ATTRIBUTE_LISTENER_ON_TRANSACTION));
        }

        com.workflow.engine.model.Process parentProcess = (com.workflow.engine.model.Process) parentElement;
        parentProcess.getEventListeners().add(listener);
    }

    @Override
    public String getElementName() {
        return ELEMENT_EVENT_LISTENER;
    }
}

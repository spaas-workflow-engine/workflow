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
package com.workflow.engine.converter.converter.export;


import cn.hutool.core.util.StrUtil;
import com.workflow.engine.converter.constants.BpmnXMLConstants;
import com.workflow.engine.model.*;
import com.workflow.engine.model.Process;

import javax.xml.stream.XMLStreamWriter;

public class SignalAndMessageDefinitionExport implements BpmnXMLConstants {

    public static void writeSignalsAndMessages(BpmnModel model, XMLStreamWriter xtw) throws Exception {

        for (Process process : model.getProcesses()) {
            for (FlowElement flowElement : process.findFlowElementsOfType(Event.class)) {
                Event event = (Event) flowElement;
                if (!event.getEventDefinitions().isEmpty()) {
                    EventDefinition eventDefinition = event.getEventDefinitions().get(0);
                    if (eventDefinition instanceof SignalEventDefinition) {
                        SignalEventDefinition signalEvent = (SignalEventDefinition) eventDefinition;
                        if (StrUtil.isNotEmpty(signalEvent.getSignalRef())) {
                            if (!model.containsSignalId(signalEvent.getSignalRef())) {
                                Signal signal = new Signal(signalEvent.getSignalRef(), signalEvent.getSignalRef());
                                model.addSignal(signal);
                            }
                        }

                    } else if (eventDefinition instanceof MessageEventDefinition) {
                        MessageEventDefinition messageEvent = (MessageEventDefinition) eventDefinition;
                        if (StrUtil.isNotEmpty(messageEvent.getMessageRef())) {
                            if (!model.containsMessageId(messageEvent.getMessageRef())) {
                                Message message = new Message(messageEvent.getMessageRef(), messageEvent.getMessageRef(), null);
                                model.addMessage(message);
                            }
                        }
                    }
                }
            }
        }

        for (Signal signal : model.getSignals()) {
            xtw.writeStartElement(ELEMENT_SIGNAL);
            xtw.writeAttribute(ATTRIBUTE_ID, signal.getId());
            xtw.writeAttribute(ATTRIBUTE_NAME, signal.getName());
            if (signal.getScope() != null) {
                xtw.writeAttribute(FLOWABLE_EXTENSIONS_NAMESPACE, ATTRIBUTE_SCOPE, signal.getScope());
            }
            xtw.writeEndElement();
        }

        for (Message message : model.getMessages()) {
            xtw.writeStartElement(ELEMENT_MESSAGE);
            String messageId = message.getId();
            // remove the namespace from the message id if set
            if (model.getTargetNamespace() != null && messageId.startsWith(model.getTargetNamespace())) {
                messageId = messageId.replace(model.getTargetNamespace(), "");
                messageId = messageId.replaceFirst(":", "");
            } else {
                for (String prefix : model.getNamespaces().keySet()) {
                    String namespace = model.getNamespace(prefix);
                    if (messageId.startsWith(namespace)) {
                        messageId = messageId.replace(model.getTargetNamespace(), "");
                        messageId = prefix + messageId;
                    }
                }
            }
            xtw.writeAttribute(ATTRIBUTE_ID, messageId);
            if (StrUtil.isNotEmpty(message.getName())) {
                xtw.writeAttribute(ATTRIBUTE_NAME, message.getName());
            }
            if (StrUtil.isNotEmpty(message.getItemRef())) {
                // replace the namespace by the right prefix
                String itemRef = message.getItemRef();
                for (String prefix : model.getNamespaces().keySet()) {
                    String namespace = model.getNamespace(prefix);
                    if (itemRef.startsWith(namespace)) {
                        if (prefix.isEmpty()) {
                            itemRef = itemRef.replace(namespace + ":", "");
                        } else {
                            itemRef = itemRef.replace(namespace, prefix);
                        }
                        break;
                    }
                }
                xtw.writeAttribute(ATTRIBUTE_ITEM_REF, itemRef);
            }
            xtw.writeEndElement();
        }
    }
}

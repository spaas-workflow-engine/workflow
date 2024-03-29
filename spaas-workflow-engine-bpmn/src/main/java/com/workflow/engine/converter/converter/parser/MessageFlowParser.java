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
package com.workflow.engine.converter.converter.parser;

import cn.hutool.core.util.StrUtil;
import com.workflow.engine.converter.constants.BpmnXMLConstants;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.MessageFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;

/**
 * @author Tijs Rademakers
 */
public class MessageFlowParser implements BpmnXMLConstants {

    protected static final Logger LOGGER = LoggerFactory.getLogger(MessageFlowParser.class.getName());

    public void parse(XMLStreamReader xtr, BpmnModel model) throws Exception {
        String id = xtr.getAttributeValue(null, ATTRIBUTE_ID);
        if (StrUtil.isNotEmpty(id)) {
            MessageFlow messageFlow = new MessageFlow();
            messageFlow.setId(id);

            String name = xtr.getAttributeValue(null, ATTRIBUTE_NAME);
            if (StrUtil.isNotEmpty(name)) {
                messageFlow.setName(name);
            }

            String sourceRef = xtr.getAttributeValue(null, ATTRIBUTE_FLOW_SOURCE_REF);
            if (StrUtil.isNotEmpty(sourceRef)) {
                messageFlow.setSourceRef(sourceRef);
            }

            String targetRef = xtr.getAttributeValue(null, ATTRIBUTE_FLOW_TARGET_REF);
            if (StrUtil.isNotEmpty(targetRef)) {
                messageFlow.setTargetRef(targetRef);
            }

            String messageRef = xtr.getAttributeValue(null, ATTRIBUTE_MESSAGE_REF);
            if (StrUtil.isNotEmpty(messageRef)) {
                messageFlow.setMessageRef(messageRef);
            }

            model.addMessageFlow(messageFlow);
        }
    }
}

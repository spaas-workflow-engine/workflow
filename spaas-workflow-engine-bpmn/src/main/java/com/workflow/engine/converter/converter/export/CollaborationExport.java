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
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.MessageFlow;
import com.workflow.engine.model.Pool;

import javax.xml.stream.XMLStreamWriter;

public class CollaborationExport implements BpmnXMLConstants {

    public static void writePools(BpmnModel model, XMLStreamWriter xtw) throws Exception {
        if (!model.getPools().isEmpty()) {
            xtw.writeStartElement(ELEMENT_COLLABORATION);
            xtw.writeAttribute(ATTRIBUTE_ID, "Collaboration");
            for (Pool pool : model.getPools()) {
                xtw.writeStartElement(ELEMENT_PARTICIPANT);
                xtw.writeAttribute(ATTRIBUTE_ID, pool.getId());
                if (StrUtil.isNotEmpty(pool.getName())) {
                    xtw.writeAttribute(ATTRIBUTE_NAME, pool.getName());
                }
                if (StrUtil.isNotEmpty(pool.getProcessRef())) {
                    xtw.writeAttribute(ATTRIBUTE_PROCESS_REF, pool.getProcessRef());
                }
                xtw.writeEndElement();
            }

            for (MessageFlow messageFlow : model.getMessageFlows().values()) {
                xtw.writeStartElement(ELEMENT_MESSAGE_FLOW);
                xtw.writeAttribute(ATTRIBUTE_ID, messageFlow.getId());
                if (StrUtil.isNotEmpty(messageFlow.getName())) {
                    xtw.writeAttribute(ATTRIBUTE_NAME, messageFlow.getName());
                }
                if (StrUtil.isNotEmpty(messageFlow.getSourceRef())) {
                    xtw.writeAttribute(ATTRIBUTE_FLOW_SOURCE_REF, messageFlow.getSourceRef());
                }
                if (StrUtil.isNotEmpty(messageFlow.getTargetRef())) {
                    xtw.writeAttribute(ATTRIBUTE_FLOW_TARGET_REF, messageFlow.getTargetRef());
                }
                if (StrUtil.isNotEmpty(messageFlow.getMessageRef())) {
                    xtw.writeAttribute(ATTRIBUTE_MESSAGE_REF, messageFlow.getMessageRef());
                }
                xtw.writeEndElement();
            }

            xtw.writeEndElement();
        }
    }
}

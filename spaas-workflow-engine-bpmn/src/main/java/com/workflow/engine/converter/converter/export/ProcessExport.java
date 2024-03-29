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
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.ExtensionAttribute;
import com.workflow.engine.model.Process;

import javax.xml.stream.XMLStreamWriter;
import java.util.Arrays;
import java.util.List;

public class ProcessExport implements BpmnXMLConstants {
    /**
     * default attributes taken from process instance attributes
     */
    public static final List<ExtensionAttribute> defaultProcessAttributes = Arrays.asList(
            new ExtensionAttribute(ATTRIBUTE_ID),
            new ExtensionAttribute(ATTRIBUTE_NAME),
            new ExtensionAttribute(ATTRIBUTE_PROCESS_EXECUTABLE),
            new ExtensionAttribute(ATTRIBUTE_PROCESS_CANDIDATE_USERS),
            new ExtensionAttribute(ATTRIBUTE_PROCESS_CANDIDATE_GROUPS),
            new ExtensionAttribute(ATTRIBUTE_PROCESS_EAGER_EXECUTION_FETCHING));

    @SuppressWarnings("unchecked")
    public static void writeProcess(Process process, BpmnModel model, XMLStreamWriter xtw) throws Exception {
        // start process element
        xtw.writeStartElement(ELEMENT_PROCESS);
        xtw.writeAttribute(ATTRIBUTE_ID, process.getId());

        if (StrUtil.isNotEmpty(process.getName())) {
            xtw.writeAttribute(ATTRIBUTE_NAME, process.getName());
        }

        xtw.writeAttribute(ATTRIBUTE_PROCESS_EXECUTABLE, Boolean.toString(process.isExecutable()));

        if (!process.getCandidateStarterUsers().isEmpty()) {
            xtw.writeAttribute(FLOWABLE_EXTENSIONS_PREFIX, FLOWABLE_EXTENSIONS_NAMESPACE, ATTRIBUTE_PROCESS_CANDIDATE_USERS, BpmnXMLUtil.convertToDelimitedString(process.getCandidateStarterUsers()));
        }

        if (!process.getCandidateStarterGroups().isEmpty()) {
            xtw.writeAttribute(FLOWABLE_EXTENSIONS_PREFIX, FLOWABLE_EXTENSIONS_NAMESPACE, ATTRIBUTE_PROCESS_CANDIDATE_GROUPS, BpmnXMLUtil.convertToDelimitedString(process.getCandidateStarterGroups()));
        }
        
        if (process.isEnableEagerExecutionTreeFetching()) {
            xtw.writeAttribute(FLOWABLE_EXTENSIONS_PREFIX, FLOWABLE_EXTENSIONS_NAMESPACE, ATTRIBUTE_PROCESS_EAGER_EXECUTION_FETCHING, "true");
        }

        // write custom attributes
        BpmnXMLUtil.writeCustomAttributes(process.getAttributes().values(), xtw, defaultProcessAttributes);

        if (StrUtil.isNotEmpty(process.getDocumentation())) {

            xtw.writeStartElement(ELEMENT_DOCUMENTATION);
            xtw.writeCharacters(process.getDocumentation());
            xtw.writeEndElement();
        }

        boolean didWriteExtensionStartElement = FlowableListenerExport.writeListeners(process, false, xtw);
        didWriteExtensionStartElement = BpmnXMLUtil.writeExtensionElements(process, didWriteExtensionStartElement, model.getNamespaces(), xtw);

        if (didWriteExtensionStartElement) {
            // closing extensions element
            xtw.writeEndElement();
        }

        LaneExport.writeLanes(process, model, xtw);
    }
}

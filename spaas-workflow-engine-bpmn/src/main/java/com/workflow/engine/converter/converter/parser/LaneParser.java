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


import com.workflow.engine.converter.constants.BpmnXMLConstants;
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.Lane;
import com.workflow.engine.model.Process;

import javax.xml.stream.XMLStreamReader;

/**
 * @author Tijs Rademakers
 */
public class LaneParser implements BpmnXMLConstants {

    public void parse(XMLStreamReader xtr, Process activeProcess, BpmnModel model) throws Exception {
        Lane lane = new Lane();
        BpmnXMLUtil.addXMLLocation(lane, xtr);
        lane.setId(xtr.getAttributeValue(null, ATTRIBUTE_ID));
        lane.setName(xtr.getAttributeValue(null, ATTRIBUTE_NAME));
        lane.setParentProcess(activeProcess);
        activeProcess.getLanes().add(lane);
        BpmnXMLUtil.parseChildElements(ELEMENT_LANE, lane, xtr, model);
    }
}

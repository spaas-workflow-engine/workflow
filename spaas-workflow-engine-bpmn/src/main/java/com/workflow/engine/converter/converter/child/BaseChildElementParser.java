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

import com.workflow.engine.converter.constants.BpmnXMLConstants;
import com.workflow.engine.model.BaseElement;
import com.workflow.engine.model.BpmnModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;

/**
 * @author Tijs Rademakers
 */
public abstract class BaseChildElementParser implements BpmnXMLConstants {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseChildElementParser.class);

    public abstract String getElementName();

    public abstract void parseChildElement(XMLStreamReader xtr, BaseElement parentElement, BpmnModel model) throws Exception;

    protected void parseChildElements(XMLStreamReader xtr, BaseElement parentElement, BpmnModel model, BaseChildElementParser parser) throws Exception {
        boolean readyWithChildElements = false;
        while (!readyWithChildElements && xtr.hasNext()) {
            xtr.next();
            if (xtr.isStartElement()) {
                if (parser.getElementName().equals(xtr.getLocalName())) {
                    parser.parseChildElement(xtr, parentElement, model);
                }

            } else if (xtr.isEndElement() && getElementName().equalsIgnoreCase(xtr.getLocalName())) {
                readyWithChildElements = true;
            }
        }
    }

    public boolean accepts(BaseElement element) {
        return element != null;
    }
}

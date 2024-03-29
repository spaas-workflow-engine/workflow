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
import com.workflow.engine.model.*;

import javax.xml.stream.XMLStreamReader;

/**
 * @author Lori Small
 */
public class FlowableCollectionParser extends BaseChildElementParser {

    @Override
    public void parseChildElement(XMLStreamReader xtr, BaseElement parentElement, BpmnModel model) throws Exception {
        if (!(parentElement instanceof MultiInstanceLoopCharacteristics)) {
            return;
        }
        
        MultiInstanceLoopCharacteristics multiInstanceLoopCharacteristics = (MultiInstanceLoopCharacteristics) parentElement;

        CollectionHandler collectionHandler = null;

        if (StrUtil.isNotEmpty(xtr.getAttributeValue(null, ATTRIBUTE_MULTIINSTANCE_COLLECTION_CLASS))) {
            collectionHandler = new CollectionHandler();
        	collectionHandler.setImplementation(xtr.getAttributeValue(null, ATTRIBUTE_MULTIINSTANCE_COLLECTION_CLASS));
        	collectionHandler.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_CLASS);
        	
        } else if (StrUtil.isNotEmpty(xtr.getAttributeValue(null, ATTRIBUTE_MULTIINSTANCE_COLLECTION_DELEGATEEXPRESSION))) {
            collectionHandler = new CollectionHandler();
        	collectionHandler.setImplementation(xtr.getAttributeValue(null, ATTRIBUTE_MULTIINSTANCE_COLLECTION_DELEGATEEXPRESSION));
        	collectionHandler.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION);
        }

        if (collectionHandler != null)  {
            BpmnXMLUtil.addXMLLocation(collectionHandler, xtr);
            multiInstanceLoopCharacteristics.setHandler(collectionHandler);
        }

        boolean readyWithCollection = false;
        try {
            while (!readyWithCollection && xtr.hasNext()) {
                xtr.next();
                if (xtr.isStartElement() && ELEMENT_MULTIINSTANCE_COLLECTION_STRING.equalsIgnoreCase(xtr.getLocalName())) {
            		// it is a string value
                    multiInstanceLoopCharacteristics.setCollectionString(xtr.getElementText());
                    
                } else if (xtr.isStartElement() && ELEMENT_MULTIINSTANCE_COLLECTION_EXPRESSION.equalsIgnoreCase(xtr.getLocalName())) {
            		// it is an expression
                    multiInstanceLoopCharacteristics.setInputDataItem(xtr.getElementText());
                    
                } else if (xtr.isEndElement() && getElementName().equalsIgnoreCase(xtr.getLocalName())) {
                	readyWithCollection = true;
                }
            }
        } catch (Exception e) {
            LOGGER.warn("Error parsing collection child elements", e);
        }
    }

    @Override
    public String getElementName() {
        return ELEMENT_MULTIINSTANCE_COLLECTION;
    }
}

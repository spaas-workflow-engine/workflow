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
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.DataStore;

import javax.xml.stream.XMLStreamReader;

/**
 * @author Tijs Rademakers
 */
public class DataStoreParser implements BpmnXMLConstants {

    public void parse(XMLStreamReader xtr, BpmnModel model) throws Exception {
        String id = xtr.getAttributeValue(null, ATTRIBUTE_ID);
        if (StrUtil.isNotEmpty(id)) {

            DataStore dataStore = new DataStore();
            dataStore.setId(xtr.getAttributeValue(null, ATTRIBUTE_ID));

            String name = xtr.getAttributeValue(null, ATTRIBUTE_NAME);
            if (StrUtil.isNotEmpty(name)) {
                dataStore.setName(name);
            }

            String itemSubjectRef = xtr.getAttributeValue(null, ATTRIBUTE_ITEM_SUBJECT_REF);
            if (StrUtil.isNotEmpty(itemSubjectRef)) {
                dataStore.setItemSubjectRef(itemSubjectRef);
            }

            BpmnXMLUtil.addXMLLocation(dataStore, xtr);

            model.addDataStore(dataStore.getId(), dataStore);

            BpmnXMLUtil.parseChildElements(ELEMENT_DATA_STORE, dataStore, xtr, model);
        }
    }
}

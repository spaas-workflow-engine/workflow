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
import com.workflow.engine.model.DataStore;

import javax.xml.stream.XMLStreamWriter;

public class DataStoreExport implements BpmnXMLConstants {

    public static void writeDataStores(BpmnModel model, XMLStreamWriter xtw) throws Exception {

        for (DataStore dataStore : model.getDataStores().values()) {
            xtw.writeStartElement(ELEMENT_DATA_STORE);
            xtw.writeAttribute(ATTRIBUTE_ID, dataStore.getId());
            xtw.writeAttribute(ATTRIBUTE_NAME, dataStore.getName());
            if (StrUtil.isNotEmpty(dataStore.getItemSubjectRef())) {
                xtw.writeAttribute(ATTRIBUTE_ITEM_SUBJECT_REF, dataStore.getItemSubjectRef());
            }

            if (StrUtil.isNotEmpty(dataStore.getDataState())) {
                xtw.writeStartElement(ELEMENT_DATA_STATE);
                xtw.writeAttribute(ATTRIBUTE_NAME, dataStore.getDataState());
                xtw.writeEndElement();
            }

            xtw.writeEndElement();
        }
    }
}

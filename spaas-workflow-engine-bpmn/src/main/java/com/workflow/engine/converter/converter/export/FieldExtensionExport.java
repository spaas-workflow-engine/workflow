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
import com.workflow.engine.model.FieldExtension;

import javax.xml.stream.XMLStreamWriter;
import java.util.List;

public class FieldExtensionExport implements BpmnXMLConstants {

    public static boolean writeFieldExtensions(List<FieldExtension> fieldExtensionList, boolean didWriteExtensionStartElement, XMLStreamWriter xtw) throws Exception {

        for (FieldExtension fieldExtension : fieldExtensionList) {

            if (StrUtil.isNotEmpty(fieldExtension.getFieldName())) {

                if (StrUtil.isNotEmpty(fieldExtension.getStringValue()) || StrUtil.isNotEmpty(fieldExtension.getExpression())) {

                    if (!didWriteExtensionStartElement) {
                        xtw.writeStartElement(ELEMENT_EXTENSIONS);
                        didWriteExtensionStartElement = true;
                    }

                    xtw.writeStartElement(FLOWABLE_EXTENSIONS_PREFIX, ELEMENT_FIELD, FLOWABLE_EXTENSIONS_NAMESPACE);
                    BpmnXMLUtil.writeDefaultAttribute(ATTRIBUTE_FIELD_NAME, fieldExtension.getFieldName(), xtw);

                    if (StrUtil.isNotEmpty(fieldExtension.getStringValue())) {
                        xtw.writeStartElement(FLOWABLE_EXTENSIONS_PREFIX, ELEMENT_FIELD_STRING, FLOWABLE_EXTENSIONS_NAMESPACE);
                        xtw.writeCData(fieldExtension.getStringValue());
                    } else {
                        xtw.writeStartElement(FLOWABLE_EXTENSIONS_PREFIX, ATTRIBUTE_FIELD_EXPRESSION, FLOWABLE_EXTENSIONS_NAMESPACE);
                        xtw.writeCData(fieldExtension.getExpression());
                    }
                    xtw.writeEndElement();
                    xtw.writeEndElement();
                }
            }
        }
        return didWriteExtensionStartElement;
    }
}

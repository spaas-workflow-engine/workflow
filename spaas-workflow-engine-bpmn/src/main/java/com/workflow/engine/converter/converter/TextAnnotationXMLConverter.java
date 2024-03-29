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
package com.workflow.engine.converter.converter;


import cn.hutool.core.util.StrUtil;
import com.workflow.engine.converter.converter.child.BaseChildElementParser;
import com.workflow.engine.converter.converter.child.TextAnnotationTextParser;
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.BaseElement;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.TextAnnotation;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tijs Rademakers
 */
public class TextAnnotationXMLConverter extends BaseBpmnXMLConverter {

    protected Map<String, BaseChildElementParser> childParserMap = new HashMap<>();

    public TextAnnotationXMLConverter() {
        TextAnnotationTextParser annotationTextParser = new TextAnnotationTextParser();
        childParserMap.put(annotationTextParser.getElementName(), annotationTextParser);
    }

    @Override
    public Class<? extends BaseElement> getBpmnElementType() {
        return TextAnnotation.class;
    }

    @Override
    protected String getXMLElementName() {
        return ELEMENT_TEXT_ANNOTATION;
    }

    @Override
    protected BaseElement convertXMLToElement(XMLStreamReader xtr, BpmnModel model) throws Exception {
        TextAnnotation textAnnotation = new TextAnnotation();
        BpmnXMLUtil.addXMLLocation(textAnnotation, xtr);
        textAnnotation.setTextFormat(xtr.getAttributeValue(null, ATTRIBUTE_TEXTFORMAT));
        parseChildElements(getXMLElementName(), textAnnotation, childParserMap, model, xtr);
        return textAnnotation;
    }

    @Override
    protected void writeAdditionalAttributes(BaseElement element, BpmnModel model, XMLStreamWriter xtw) throws Exception {
        TextAnnotation textAnnotation = (TextAnnotation) element;
        writeDefaultAttribute(ATTRIBUTE_TEXTFORMAT, textAnnotation.getTextFormat(), xtw);
    }

    @Override
    protected void writeAdditionalChildElements(BaseElement element, BpmnModel model, XMLStreamWriter xtw) throws Exception {
        TextAnnotation textAnnotation = (TextAnnotation) element;
        if (StrUtil.isNotEmpty(textAnnotation.getText())) {
            xtw.writeStartElement(ELEMENT_TEXT_ANNOTATION_TEXT);
            xtw.writeCharacters(textAnnotation.getText());
            xtw.writeEndElement();
        }
    }
}

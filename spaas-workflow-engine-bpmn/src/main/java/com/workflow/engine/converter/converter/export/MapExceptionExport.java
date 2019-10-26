package com.workflow.engine.converter.converter.export;


import cn.hutool.core.util.StrUtil;
import com.workflow.engine.converter.constants.BpmnXMLConstants;
import com.workflow.engine.converter.converter.util.BpmnXMLUtil;
import com.workflow.engine.model.MapExceptionEntry;

import javax.xml.stream.XMLStreamWriter;
import java.util.List;

public class MapExceptionExport implements BpmnXMLConstants {

    public static boolean writeMapExceptionExtensions(List<MapExceptionEntry> mapExceptionList, boolean didWriteExtensionStartElement, XMLStreamWriter xtw) throws Exception {

        for (MapExceptionEntry mapException : mapExceptionList) {

            if (!didWriteExtensionStartElement) {
                xtw.writeStartElement(ELEMENT_EXTENSIONS);
                didWriteExtensionStartElement = true;
            }

            if (StrUtil.isNotEmpty(mapException.getErrorCode())) {
                xtw.writeStartElement(FLOWABLE_EXTENSIONS_PREFIX, MAP_EXCEPTION, FLOWABLE_EXTENSIONS_NAMESPACE);

                BpmnXMLUtil.writeDefaultAttribute(MAP_EXCEPTION_ERRORCODE, mapException.getErrorCode(), xtw);
                BpmnXMLUtil.writeDefaultAttribute(MAP_EXCEPTION_ANDCHILDREN, Boolean.toString(mapException.isAndChildren()), xtw);

                if (StrUtil.isNotEmpty(mapException.getClassName())) {
                    xtw.writeCData(mapException.getClassName());
                }
                xtw.writeEndElement(); //end flowable:mapException
            }
        }
        return didWriteExtensionStartElement;
    }

}

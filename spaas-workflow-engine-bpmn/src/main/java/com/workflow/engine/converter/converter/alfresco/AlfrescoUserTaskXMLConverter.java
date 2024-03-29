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
package com.workflow.engine.converter.converter.alfresco;

import com.workflow.engine.converter.converter.UserTaskXMLConverter;
import com.workflow.engine.model.BaseElement;
import com.workflow.engine.model.alfresco.AlfrescoUserTask;

/**
 * @author Tijs Rademakers
 */
public class AlfrescoUserTaskXMLConverter extends UserTaskXMLConverter {

    @Override
    public Class<? extends BaseElement> getBpmnElementType() {
        return AlfrescoUserTask.class;
    }

}

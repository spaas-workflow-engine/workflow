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
package com.workflow.engine.validation.validator.impl;


import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.Process;
import com.workflow.engine.model.SubProcess;
import com.workflow.engine.model.ValuedDataObject;
import com.workflow.engine.validation.ValidationError;
import com.workflow.engine.validation.validator.Problems;
import com.workflow.engine.validation.validator.ProcessLevelValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataObjectValidator extends ProcessLevelValidator {

    @Override
    protected void executeValidation(BpmnModel bpmnModel, Process process, List<ValidationError> errors) {

        // Gather data objects
        List<ValuedDataObject> allDataObjects = new ArrayList<>(process.getDataObjects());
        List<SubProcess> subProcesses = process.findFlowElementsOfType(SubProcess.class, true);
        for (SubProcess subProcess : subProcesses) {
            allDataObjects.addAll(subProcess.getDataObjects());
        }

        // Validate
        for (ValuedDataObject dataObject : allDataObjects) {
            if (StringUtils.isEmpty(dataObject.getName())) {
                addError(errors, Problems.DATA_OBJECT_MISSING_NAME, process, dataObject, "Name is mandatory for a data object");
            }
        }

    }

}

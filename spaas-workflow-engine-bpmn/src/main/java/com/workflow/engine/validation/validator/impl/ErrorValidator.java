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
import com.workflow.engine.validation.ValidationError;
import com.workflow.engine.validation.validator.Problems;
import com.workflow.engine.validation.validator.ValidatorImpl;

import java.util.List;

/**
 * @author jbarrez
 */
public class ErrorValidator extends ValidatorImpl {

    @Override
    public void validate(BpmnModel bpmnModel, List<ValidationError> errors) {
        if (bpmnModel.getErrors() != null) {
            for (String errorRef : bpmnModel.getErrors().keySet()) {
                String errorCode = bpmnModel.getErrors().get(errorRef);
                if ("".equals(errorCode)) {
                    addError(errors, Problems.ERROR_MISSING_ERROR_CODE, null, errorRef, "Invalid error code: empty errorCode");
                }
            }
        }
    }

}

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


import cn.hutool.core.util.StrUtil;
import com.workflow.engine.model.*;
import com.workflow.engine.model.Process;
import com.workflow.engine.validation.ValidationError;
import com.workflow.engine.validation.validator.Problems;

import java.util.List;

/**
 * @author jbarrez
 */
public class SendTaskValidator extends ExternalInvocationTaskValidator {

    @Override
    protected void executeValidation(BpmnModel bpmnModel, Process process, List<ValidationError> errors) {
        List<SendTask> sendTasks = process.findFlowElementsOfType(SendTask.class);
        for (SendTask sendTask : sendTasks) {

            // Verify implementation
            if (StrUtil.isEmpty(sendTask.getType()) && !ImplementationType.IMPLEMENTATION_TYPE_WEBSERVICE.equalsIgnoreCase(sendTask.getImplementationType())) {
                addError(errors, Problems.SEND_TASK_INVALID_IMPLEMENTATION, process, sendTask, "One of the attributes 'type' or 'operation' is mandatory on sendTask");
            }

            // Verify type
            if (StrUtil.isNotEmpty(sendTask.getType())) {

                if (!sendTask.getType().equalsIgnoreCase("mail") && !sendTask.getType().equalsIgnoreCase("mule") && !sendTask.getType().equalsIgnoreCase("camel")) {
                    addError(errors, Problems.SEND_TASK_INVALID_TYPE, process, sendTask, "Invalid or unsupported type for send task");
                }

                if (sendTask.getType().equalsIgnoreCase("mail")) {
                    validateFieldDeclarationsForEmail(process, sendTask, sendTask.getFieldExtensions(), errors);
                }

            }

            // Web service
            verifyWebservice(bpmnModel, process, sendTask, errors);
        }
    }

    protected void verifyWebservice(BpmnModel bpmnModel, Process process, SendTask sendTask, List<ValidationError> errors) {
        if (ImplementationType.IMPLEMENTATION_TYPE_WEBSERVICE.equalsIgnoreCase(sendTask.getImplementationType()) && StrUtil.isNotEmpty(sendTask.getOperationRef())) {

            boolean operationFound = false;
            if (bpmnModel.getInterfaces() != null && !bpmnModel.getInterfaces().isEmpty()) {
                for (Interface bpmnInterface : bpmnModel.getInterfaces()) {
                    if (bpmnInterface.getOperations() != null && !bpmnInterface.getOperations().isEmpty()) {
                        for (Operation operation : bpmnInterface.getOperations()) {
                            if (operation.getId() != null && operation.getId().equals(sendTask.getOperationRef())) {
                                operationFound = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (!operationFound) {
                addError(errors, Problems.SEND_TASK_WEBSERVICE_INVALID_OPERATION_REF, process, sendTask, "Invalid operation reference for send task");
            }

        }
    }

}

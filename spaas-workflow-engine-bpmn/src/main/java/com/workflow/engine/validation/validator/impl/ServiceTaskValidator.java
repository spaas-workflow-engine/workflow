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
import com.workflow.engine.validation.ValidationError;
import com.workflow.engine.validation.validator.Problems;

import com.workflow.engine.model.Process;
import java.util.List;

/**
 * @author jbarrez
 */
public class ServiceTaskValidator extends ExternalInvocationTaskValidator {

    @Override
    protected void executeValidation(BpmnModel bpmnModel, com.workflow.engine.model.Process process, List<ValidationError> errors) {
        List<ServiceTask> serviceTasks = process.findFlowElementsOfType(ServiceTask.class);
        for (ServiceTask serviceTask : serviceTasks) {
            verifyImplementation(process, serviceTask, errors);
            verifyType(process, serviceTask, errors);
            verifyResultVariableName(process, serviceTask, errors);
            verifyWebservice(bpmnModel, process, serviceTask, errors);
        }

    }

    protected void verifyImplementation(com.workflow.engine.model.Process process, ServiceTask serviceTask, List<ValidationError> errors) {
        if (!ImplementationType.IMPLEMENTATION_TYPE_CLASS.equalsIgnoreCase(serviceTask.getImplementationType())
                && !ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION.equalsIgnoreCase(serviceTask.getImplementationType())
                && !ImplementationType.IMPLEMENTATION_TYPE_EXPRESSION.equalsIgnoreCase(serviceTask.getImplementationType())
                && !ImplementationType.IMPLEMENTATION_TYPE_WEBSERVICE.equalsIgnoreCase(serviceTask.getImplementationType()) 
                && !ServiceTask.CASE_TASK.equalsIgnoreCase(serviceTask.getType()) 
                && StrUtil.isEmpty(serviceTask.getType())) {
            
            addError(errors, Problems.SERVICE_TASK_MISSING_IMPLEMENTATION, process, serviceTask,
                    "One of the attributes 'class', 'delegateExpression', 'type', 'operation', or 'expression' is mandatory on serviceTask.");
        }
    }

    protected void verifyType(Process process, ServiceTask serviceTask, List<ValidationError> errors) {
        if (StrUtil.isNotEmpty(serviceTask.getType())) {

            if (!serviceTask.getType().equalsIgnoreCase("mail") && !serviceTask.getType().equalsIgnoreCase("mule") && !serviceTask.getType().equalsIgnoreCase("camel")
                    && !serviceTask.getType().equalsIgnoreCase("shell") && !serviceTask.getType().equalsIgnoreCase("dmn") 
                    && !serviceTask.getType().equalsIgnoreCase("http") && !serviceTask.getType().equalsIgnoreCase("case")) {

                addError(errors, Problems.SERVICE_TASK_INVALID_TYPE, process, serviceTask, "Invalid or unsupported service task type");
            }

            if (serviceTask.getType().equalsIgnoreCase("mail")) {
                validateFieldDeclarationsForEmail(process, serviceTask, serviceTask.getFieldExtensions(), errors);
            } else if (serviceTask.getType().equalsIgnoreCase("shell")) {
                validateFieldDeclarationsForShell(process, serviceTask, serviceTask.getFieldExtensions(), errors);
            } else if (serviceTask.getType().equalsIgnoreCase("dmn")) {
                validateFieldDeclarationsForDmn(process, serviceTask, serviceTask.getFieldExtensions(), errors);
            } else if (serviceTask.getType().equalsIgnoreCase("http")) {
                validateFieldDeclarationsForHttp(process, serviceTask, serviceTask.getFieldExtensions(), errors);
            } else if (serviceTask.getType().equalsIgnoreCase("case")) {
                validateFieldDeclarationsForCase(process, (CaseServiceTask) serviceTask, errors);
            }

        }
    }

    protected void verifyResultVariableName(Process process, ServiceTask serviceTask, List<ValidationError> errors) {
        if (StrUtil.isNotEmpty(serviceTask.getResultVariableName())
                && (ImplementationType.IMPLEMENTATION_TYPE_CLASS.equals(serviceTask.getImplementationType()) || 
                                ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION.equals(serviceTask.getImplementationType()))) {
            
            addError(errors, Problems.SERVICE_TASK_RESULT_VAR_NAME_WITH_DELEGATE, process, serviceTask, "'resultVariableName' not supported for service tasks using 'class' or 'delegateExpression");
        }

        if (serviceTask.isUseLocalScopeForResultVariable() && StrUtil.isEmpty(serviceTask.getResultVariableName())) {
            addWarning(errors, Problems.SERVICE_TASK_USE_LOCAL_SCOPE_FOR_RESULT_VAR_WITHOUT_RESULT_VARIABLE_NAME, process, serviceTask, "'useLocalScopeForResultVariable' is set, but no 'resultVariableName' is set. The property would not be used");
        }
    }

    protected void verifyWebservice(BpmnModel bpmnModel, Process process, ServiceTask serviceTask, List<ValidationError> errors) {
        if (ImplementationType.IMPLEMENTATION_TYPE_WEBSERVICE.equalsIgnoreCase(serviceTask.getImplementationType()) && StrUtil.isNotEmpty(serviceTask.getOperationRef())) {

            boolean operationFound = false;
            if (bpmnModel.getInterfaces() != null && !bpmnModel.getInterfaces().isEmpty()) {
                for (Interface bpmnInterface : bpmnModel.getInterfaces()) {
                    if (bpmnInterface.getOperations() != null && !bpmnInterface.getOperations().isEmpty()) {
                        for (Operation operation : bpmnInterface.getOperations()) {
                            if (operation.getId() != null && operation.getId().equals(serviceTask.getOperationRef())) {
                                operationFound = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (!operationFound) {
                addError(errors, Problems.SERVICE_TASK_WEBSERVICE_INVALID_OPERATION_REF, process, serviceTask, "Invalid operation reference");
            }

        }
    }

}

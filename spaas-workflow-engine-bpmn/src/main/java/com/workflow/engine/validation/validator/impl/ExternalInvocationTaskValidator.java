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


import com.workflow.engine.model.CaseServiceTask;
import com.workflow.engine.model.FieldExtension;
import com.workflow.engine.model.Process;
import com.workflow.engine.model.TaskWithFieldExtensions;
import com.workflow.engine.validation.ValidationError;
import com.workflow.engine.validation.validator.Problems;
import com.workflow.engine.validation.validator.ProcessLevelValidator;
import org.springframework.util.StringUtils;

import java.util.List;

public abstract class ExternalInvocationTaskValidator extends ProcessLevelValidator {

    protected void validateFieldDeclarationsForEmail(Process process, TaskWithFieldExtensions task, List<FieldExtension> fieldExtensions, List<ValidationError> errors) {
        boolean toDefined = false;
        boolean textOrHtmlDefined = false;

        for (FieldExtension fieldExtension : fieldExtensions) {
            if (fieldExtension.getFieldName().equals("to")) {
                toDefined = true;
            }
            if (fieldExtension.getFieldName().equals("html")) {
                textOrHtmlDefined = true;
            }
            if (fieldExtension.getFieldName().equals("htmlVar")) {
                textOrHtmlDefined = true;
            }
            if (fieldExtension.getFieldName().equals("text")) {
                textOrHtmlDefined = true;
            }
            if (fieldExtension.getFieldName().equals("textVar")) {
                textOrHtmlDefined = true;
            }
        }

        if (!toDefined) {
            addError(errors, Problems.MAIL_TASK_NO_RECIPIENT, process, task, "No recipient is defined on the mail activity");
        }
        if (!textOrHtmlDefined) {
            addError(errors, Problems.MAIL_TASK_NO_CONTENT, process, task, "Text, html, textVar or htmlVar field should be provided");
        }
    }

    protected void validateFieldDeclarationsForShell(Process process, TaskWithFieldExtensions task, List<FieldExtension> fieldExtensions, List<ValidationError> errors) {
        boolean shellCommandDefined = false;

        for (FieldExtension fieldExtension : fieldExtensions) {
            String fieldName = fieldExtension.getFieldName();
            String fieldValue = fieldExtension.getStringValue();

            if (fieldName.equals("command")) {
                shellCommandDefined = true;
            }

            if ((fieldName.equals("wait") || fieldName.equals("redirectError") || fieldName.equals("cleanEnv")) && !fieldValue.toLowerCase().equals("true") && !fieldValue.toLowerCase().equals("false")) {
                addError(errors, Problems.SHELL_TASK_INVALID_PARAM, process, task, "Undefined parameter value for shell field");
            }

        }

        if (!shellCommandDefined) {
            addError(errors, Problems.SHELL_TASK_NO_COMMAND, process, task, "No shell command is defined on the shell activity");
        }
    }

    protected void validateFieldDeclarationsForDmn(Process process, TaskWithFieldExtensions task, List<FieldExtension> fieldExtensions, List<ValidationError> errors) {
        boolean keyDefined = false;

        for (FieldExtension fieldExtension : fieldExtensions) {
            String fieldName = fieldExtension.getFieldName();
            String fieldValue = fieldExtension.getStringValue();

            if (fieldName.equals("decisionTableReferenceKey") && fieldValue != null && fieldValue.length() > 0) {
                keyDefined = true;
                break;
            }
        }

        if (!keyDefined) {
            addError(errors, Problems.DMN_TASK_NO_KEY, process, task, "No decision table reference key is defined on the dmn activity");
        }
    }

    protected void validateFieldDeclarationsForHttp(Process process, TaskWithFieldExtensions task, List<FieldExtension> fieldExtensions, List<ValidationError> errors) {
        boolean requestMethodDefined = false;
        boolean requestUrlDefined = false;

        for (FieldExtension fieldExtension : fieldExtensions) {

            String fieldName = fieldExtension.getFieldName();
            String fieldValue = fieldExtension.getStringValue();
            String fieldExpression = fieldExtension.getExpression();

            if (fieldName.equals("requestMethod") && ((fieldValue != null && fieldValue.length() > 0) || (fieldExpression != null && fieldExpression.length() > 0))) {
                requestMethodDefined = true;
            }

            if (fieldName.equals("requestUrl") && ((fieldValue != null && fieldValue.length() > 0) || (fieldExpression != null && fieldExpression.length() > 0))) {
                requestUrlDefined = true;
            }
        }

        if (!requestMethodDefined) {
            addError(errors, Problems.HTTP_TASK_NO_REQUEST_METHOD, process, task, "No request method is defined on the http activity");
        }

        if (!requestUrlDefined) {
            addError(errors, Problems.HTTP_TASK_NO_REQUEST_URL, process, task, "No request url is defined on the http activity");
        }

    }
    
    protected void validateFieldDeclarationsForCase(Process process, CaseServiceTask caseServiceTask, List<ValidationError> errors) {
        if (StringUtils.isEmpty(caseServiceTask.getCaseDefinitionKey())) {
            addError(errors, Problems.CASE_TASK_NO_CASE_DEFINITION_KEY, process, caseServiceTask, "No case definition key is defined on the case task");
        }
    }

}

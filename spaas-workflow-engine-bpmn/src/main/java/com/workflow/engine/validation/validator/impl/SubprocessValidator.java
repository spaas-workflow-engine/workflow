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
import com.workflow.engine.model.EventSubProcess;
import com.workflow.engine.model.Process;
import com.workflow.engine.model.StartEvent;
import com.workflow.engine.model.SubProcess;
import com.workflow.engine.validation.ValidationError;
import com.workflow.engine.validation.validator.Problems;
import com.workflow.engine.validation.validator.ProcessLevelValidator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubprocessValidator extends ProcessLevelValidator {

    @Override
    protected void executeValidation(BpmnModel bpmnModel, Process process, List<ValidationError> errors) {
        List<SubProcess> subProcesses = process.findFlowElementsOfType(SubProcess.class);
        for (SubProcess subProcess : subProcesses) {

            if (!(subProcess instanceof EventSubProcess)) {

                // Verify start events
                List<StartEvent> startEvents = process.findFlowElementsInSubProcessOfType(subProcess, StartEvent.class, false);
                if (startEvents.size() > 1) {
                    addError(errors, Problems.SUBPROCESS_MULTIPLE_START_EVENTS, process, subProcess, "Multiple start events not supported for subprocess");
                }

                for (StartEvent startEvent : startEvents) {
                    if (!startEvent.getEventDefinitions().isEmpty()) {
                        addError(errors, Problems.SUBPROCESS_START_EVENT_EVENT_DEFINITION_NOT_ALLOWED, process, startEvent, "event definitions only allowed on start event if subprocess is an event subprocess");
                    }
                }

            }

        }

    }

}

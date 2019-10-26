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


import com.workflow.engine.model.*;
import com.workflow.engine.model.Process;
import com.workflow.engine.validation.ValidationError;
import com.workflow.engine.validation.validator.Problems;
import com.workflow.engine.validation.validator.ProcessLevelValidator;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class IntermediateCatchEventValidator extends ProcessLevelValidator {

    @Override
    protected void executeValidation(BpmnModel bpmnModel, Process process, List<ValidationError> errors) {
        List<IntermediateCatchEvent> intermediateCatchEvents = process.findFlowElementsOfType(IntermediateCatchEvent.class);
        for (IntermediateCatchEvent intermediateCatchEvent : intermediateCatchEvents) {
            EventDefinition eventDefinition = null;
            if (!intermediateCatchEvent.getEventDefinitions().isEmpty()) {
                eventDefinition = intermediateCatchEvent.getEventDefinitions().get(0);
            }

            if (eventDefinition == null) {
                addError(errors, Problems.INTERMEDIATE_CATCH_EVENT_NO_EVENTDEFINITION, process, intermediateCatchEvent, "No event definition for intermediate catch event ");
                
            } else {
                if (!(eventDefinition instanceof TimerEventDefinition) && !(eventDefinition instanceof SignalEventDefinition) &&
                                !(eventDefinition instanceof MessageEventDefinition) && !(eventDefinition instanceof ConditionalEventDefinition)) {
                    
                    addError(errors, Problems.INTERMEDIATE_CATCH_EVENT_INVALID_EVENTDEFINITION, process, intermediateCatchEvent, "Unsupported intermediate catch event type");
                }
            }
        }
    }

}

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

import java.util.List;

/**
 * @author jbarrez
 */
public class IntermediateThrowEventValidator extends ProcessLevelValidator {

    @Override
    protected void executeValidation(BpmnModel bpmnModel, Process process, List<ValidationError> errors) {
        List<ThrowEvent> throwEvents = process.findFlowElementsOfType(ThrowEvent.class);
        for (ThrowEvent throwEvent : throwEvents) {
            EventDefinition eventDefinition = null;
            if (!throwEvent.getEventDefinitions().isEmpty()) {
                eventDefinition = throwEvent.getEventDefinitions().get(0);
            }

            if (eventDefinition != null && !(eventDefinition instanceof SignalEventDefinition) &&
                            !(eventDefinition instanceof EscalationEventDefinition) && !(eventDefinition instanceof CompensateEventDefinition)) {
                
                addError(errors, Problems.THROW_EVENT_INVALID_EVENTDEFINITION, process, throwEvent, "Unsupported intermediate throw event type");
            }
        }
    }

}

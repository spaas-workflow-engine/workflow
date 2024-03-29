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
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.ExclusiveGateway;
import com.workflow.engine.model.Process;
import com.workflow.engine.model.SequenceFlow;
import com.workflow.engine.validation.ValidationError;
import com.workflow.engine.validation.validator.Problems;
import com.workflow.engine.validation.validator.ProcessLevelValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbarrez
 */
public class ExclusiveGatewayValidator extends ProcessLevelValidator {

    @Override
    protected void executeValidation(BpmnModel bpmnModel, Process process, List<ValidationError> errors) {
        List<ExclusiveGateway> gateways = process.findFlowElementsOfType(ExclusiveGateway.class);
        for (ExclusiveGateway gateway : gateways) {
            validateExclusiveGateway(process, gateway, errors);
        }
    }

    public void validateExclusiveGateway(Process process, ExclusiveGateway exclusiveGateway, List<ValidationError> errors) {
        if (exclusiveGateway.getOutgoingFlows().isEmpty()) {
            addError(errors, Problems.EXCLUSIVE_GATEWAY_NO_OUTGOING_SEQ_FLOW, process, exclusiveGateway, "Exclusive gateway has no outgoing sequence flow");
        } else if (exclusiveGateway.getOutgoingFlows().size() == 1) {
            SequenceFlow sequenceFlow = exclusiveGateway.getOutgoingFlows().get(0);
            if (StrUtil.isNotEmpty(sequenceFlow.getConditionExpression())) {
                addError(errors, Problems.EXCLUSIVE_GATEWAY_CONDITION_NOT_ALLOWED_ON_SINGLE_SEQ_FLOW, process, exclusiveGateway,
                        "Exclusive gateway has only one outgoing sequence flow. This is not allowed to have a condition.");
            }
        } else {
            String defaultSequenceFlow = exclusiveGateway.getDefaultFlow();

            List<SequenceFlow> flowsWithoutCondition = new ArrayList<>();
            for (SequenceFlow flow : exclusiveGateway.getOutgoingFlows()) {
                String condition = flow.getConditionExpression();
                boolean isDefaultFlow = flow.getId() != null && flow.getId().equals(defaultSequenceFlow);
                boolean hasCondition = StrUtil.isNotEmpty(condition);

                if (!hasCondition && !isDefaultFlow) {
                    flowsWithoutCondition.add(flow);
                }
                if (hasCondition && isDefaultFlow) {
                    addError(errors, Problems.EXCLUSIVE_GATEWAY_CONDITION_ON_DEFAULT_SEQ_FLOW, process, exclusiveGateway, "Default sequenceflow has a condition, which is not allowed");
                }
            }

            if (!flowsWithoutCondition.isEmpty()) {
                addWarning(errors, Problems.EXCLUSIVE_GATEWAY_SEQ_FLOW_WITHOUT_CONDITIONS, process, exclusiveGateway,
                        "Exclusive gateway has at least one outgoing sequence flow without a condition (which isn't the default one)");
            }

        }
    }

}

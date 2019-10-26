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


import com.workflow.engine.model.Artifact;
import com.workflow.engine.model.Association;
import com.workflow.engine.model.BpmnModel;
import com.workflow.engine.model.Process;
import com.workflow.engine.validation.ValidationError;
import com.workflow.engine.validation.validator.Problems;
import com.workflow.engine.validation.validator.ValidatorImpl;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author jbarrez
 */
public class AssociationValidator extends ValidatorImpl {

    @Override
    public void validate(BpmnModel bpmnModel, List<ValidationError> errors) {

        // Global associations
        Collection<Artifact> artifacts = bpmnModel.getGlobalArtifacts();
        if (artifacts != null) {
            for (Artifact artifact : artifacts) {
                if (artifact instanceof Association) {
                    validate(null, (Association) artifact, errors);
                }
            }
        }

        // Process associations
        for (Process process : bpmnModel.getProcesses()) {
            artifacts = process.getArtifacts();
            for (Artifact artifact : artifacts) {
                if (artifact instanceof Association) {
                    validate(process, (Association) artifact, errors);
                }
            }
        }

    }

    protected void validate(Process process, Association association, List<ValidationError> errors) {
        if (StringUtils.isEmpty(association.getSourceRef())) {
            addError(errors, Problems.ASSOCIATION_INVALID_SOURCE_REFERENCE, process, association, "association element missing attribute 'sourceRef'");
        }
        if (StringUtils.isEmpty(association.getTargetRef())) {
            addError(errors, Problems.ASSOCIATION_INVALID_TARGET_REFERENCE, process, association, "association element missing attribute 'targetRef'");
        }
    }

}

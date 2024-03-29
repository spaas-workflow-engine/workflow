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
package com.workflow.engine.model;

/**
 * @author Tijs Rademakers
 */
public class MultiInstanceLoopCharacteristics extends BaseElement {

    protected String inputDataItem;
    protected String collectionString;
    protected CollectionHandler collectionHandler;
    protected String loopCardinality;
    protected String completionCondition;
    protected String elementVariable;
    protected String elementIndexVariable;
    protected boolean sequential;

    public String getInputDataItem() {
        return inputDataItem;
    }

    public void setInputDataItem(String inputDataItem) {
        this.inputDataItem = inputDataItem;
    }

    public String getCollectionString() {
        return collectionString;
    }

    public void setCollectionString(String collectionString) {
        this.collectionString = collectionString;
    }

    public CollectionHandler getHandler() {
		return collectionHandler;
	}

	public void setHandler(CollectionHandler collectionHandler) {
		this.collectionHandler = collectionHandler;
	}

	public String getLoopCardinality() {
        return loopCardinality;
    }

    public void setLoopCardinality(String loopCardinality) {
        this.loopCardinality = loopCardinality;
    }

    public String getCompletionCondition() {
        return completionCondition;
    }

    public void setCompletionCondition(String completionCondition) {
        this.completionCondition = completionCondition;
    }

    public String getElementVariable() {
        return elementVariable;
    }

    public void setElementVariable(String elementVariable) {
        this.elementVariable = elementVariable;
    }

    public String getElementIndexVariable() {
        return elementIndexVariable;
    }

    public void setElementIndexVariable(String elementIndexVariable) {
        this.elementIndexVariable = elementIndexVariable;
    }

    public boolean isSequential() {
        return sequential;
    }

    public void setSequential(boolean sequential) {
        this.sequential = sequential;
    }

    @Override
    public MultiInstanceLoopCharacteristics clone() {
        MultiInstanceLoopCharacteristics clone = new MultiInstanceLoopCharacteristics();
        clone.setValues(this);
        return clone;
    }

    public void setValues(MultiInstanceLoopCharacteristics otherLoopCharacteristics) {
        setInputDataItem(otherLoopCharacteristics.getInputDataItem());
        setCollectionString(otherLoopCharacteristics.getCollectionString());
        if (otherLoopCharacteristics.getHandler() != null) {
        	setHandler(otherLoopCharacteristics.getHandler().clone());
        }
        setLoopCardinality(otherLoopCharacteristics.getLoopCardinality());
        setCompletionCondition(otherLoopCharacteristics.getCompletionCondition());
        setElementVariable(otherLoopCharacteristics.getElementVariable());
        setElementIndexVariable(otherLoopCharacteristics.getElementIndexVariable());
        setSequential(otherLoopCharacteristics.isSequential());
    }
}

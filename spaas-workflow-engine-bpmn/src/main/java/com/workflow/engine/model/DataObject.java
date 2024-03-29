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
 * @author Lori Small
 */
public class DataObject extends FlowElement {

    protected ItemDefinition itemSubjectRef;

    public ItemDefinition getItemSubjectRef() {
        return itemSubjectRef;
    }

    public void setItemSubjectRef(ItemDefinition itemSubjectRef) {
        this.itemSubjectRef = itemSubjectRef;
    }

    @Override
    public DataObject clone() {
        DataObject clone = new DataObject();
        clone.setValues(this);
        return clone;
    }

    public void setValues(DataObject otherElement) {
        super.setValues(otherElement);

        setId(otherElement.getId());
        setName(otherElement.getName());
        setItemSubjectRef(otherElement.getItemSubjectRef());
    }
}

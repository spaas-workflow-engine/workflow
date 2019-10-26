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


import cn.hutool.core.util.StrUtil;

/**
 * @author Lori Small
 */
public class LongDataObject extends ValuedDataObject {

    @Override
    public void setValue(Object value) {
    	if (value instanceof String && !StrUtil.isEmpty(((String) value).trim())) {
    		this.value = Long.valueOf(value.toString());
    	} else if (value instanceof Number) {
    		this.value = (Long) value;
    	}
    }

    @Override
    public LongDataObject clone() {
        LongDataObject clone = new LongDataObject();
        clone.setValues(this);
        return clone;
    }
}

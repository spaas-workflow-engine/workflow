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
 * @author Saeid Mirzaei
 */

public class MapExceptionEntry {

    protected String errorCode;
    protected String className;
    protected boolean andChildren;
    protected String rootCause;

    public MapExceptionEntry(){
        
    }

    public MapExceptionEntry(String errorCode, String className, boolean andChildren, String rootCause) {
        this.errorCode = errorCode;
        this.className = className;
        this.andChildren = andChildren;
        this.rootCause = rootCause;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isAndChildren() {
        return andChildren;
    }

    public void setAndChildren(boolean andChildren) {
        this.andChildren = andChildren;
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

}

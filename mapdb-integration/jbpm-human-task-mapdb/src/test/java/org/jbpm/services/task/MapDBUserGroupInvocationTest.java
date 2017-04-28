/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.jbpm.services.task;

import java.util.Map;

import org.jbpm.persistence.mapdb.util.MapDBProcessPersistenceUtil;
import org.jbpm.services.task.util.MapDBTaskPersistenceUtil;
import org.junit.After;
import org.junit.Before;
import org.kie.api.runtime.Environment;
import org.kie.api.runtime.EnvironmentName;

public class MapDBUserGroupInvocationTest extends UserGroupInvocationTest {
    
    private Map<String, Object> context;
    
    @Before
    public void setup() {
        context = MapDBProcessPersistenceUtil.setupMapDB();
        Environment env = MapDBProcessPersistenceUtil.createEnvironment(context);
        this.callback = new CountInvokeUserGroupCallback();
        env.set(EnvironmentName.TASK_USER_GROUP_CALLBACK, callback);
        this.taskService = MapDBTaskPersistenceUtil.createTaskService(env);
    }

    @After
    public void clean() {
        MapDBProcessPersistenceUtil.cleanUp(context);
    }
}
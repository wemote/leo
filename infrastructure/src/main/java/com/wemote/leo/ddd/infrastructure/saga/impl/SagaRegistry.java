/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wemote.leo.ddd.infrastructure.saga.impl;

import com.wemote.leo.ddd.infrastructure.saga.SagaInstance;
import com.wemote.leo.ddd.infrastructure.saga.SagaManager;

import java.util.Collection;

public interface SagaRegistry {

    @SuppressWarnings("rawtypes")
    Collection<SagaManager> getLoadersForEvent(Object event);

    @SuppressWarnings("rawtypes")
    SagaInstance createSagaInstance(Class<? extends SagaInstance> sagaType);
}

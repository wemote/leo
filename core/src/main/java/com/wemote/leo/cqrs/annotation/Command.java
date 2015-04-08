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
package com.wemote.leo.cqrs.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@Documented
public @interface Command {
    /**
     * Suggestion for a Server that this command may be run in asynchronous way.
     * <br>
     * If true than {@link com.wemote.leo.cqrs.command.handler.CommandHandler} must return void - otherwise Server will throw an exception
     *
     * @return
     */
    boolean asynchronous() default false;

    /**
     * Suggestion for a Server that this command should checked if the same command is sent again.<br>
     * If true than command class must implement equals and hashCode
     *
     * @return
     */
    boolean unique() default false;

    /**
     * If unique is true than this property may specify maximum timeout in milliseconds before same command can be executed
     *
     * @return
     */
    long uniqueStorageTimeout() default 0L;
}

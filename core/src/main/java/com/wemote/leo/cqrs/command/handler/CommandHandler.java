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
package com.wemote.leo.cqrs.command.handler;

import com.wemote.leo.cqrs.annotation.Command;

/**
 * @param <C> command
 * @param <R> result type - for asynchronous {@link Command}commands (asynchronous=true) should be {@link Void}
 * @author jayon.xu@gmail.com
 */
public interface CommandHandler<C, R> {

    public R handle(C command);
}

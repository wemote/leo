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
package com.wemote.leo.quickstart.demo.readmodel.impl;

import com.google.common.collect.Lists;
import com.wemote.leo.cqrs.query.PaginatedResult;
import com.wemote.leo.ddd.annotation.domain.FinderImpl;
import com.wemote.leo.ddd.support.domain.AggregateId;
import com.wemote.leo.quickstart.demo.domain.TodoItem;
import com.wemote.leo.quickstart.demo.readmodel.TodoItemDto;
import com.wemote.leo.quickstart.demo.readmodel.TodoItemFinder;
import com.wemote.leo.quickstart.demo.readmodel.TodoItemQuery;
import com.wemote.leo.quickstart.demo.readmodel.TodoItemQueryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.inject.Inject;
import java.util.List;

@FinderImpl
public class JpaTodoItemFinder implements TodoItemFinder {

    @Inject
    private TodoItemQueryRepository todoItemQueryRepository;

    @Override
    public TodoItemDto findByAggregateId(AggregateId todoItemId) {
        TodoItem todoItem = this.todoItemQueryRepository.findByAggregateId(todoItemId);

        if (todoItem != null) {
            return new TodoItemDto(todoItem.getAggregateId().getId(), todoItem.getName());
        }
        return null;
    }

    @Override
    public PaginatedResult<TodoItemDto> findByTodoItemQuery(TodoItemQuery todoItemQuery, Pageable pageable) {
        Page<TodoItem> todoItems = this.todoItemQueryRepository.findByName(todoItemQuery.getName(), pageable);
        if (todoItems != null) {
            List<TodoItemDto> todoItemDtoList = Lists.newArrayList();
            for (TodoItem todoItem : todoItems) {
                todoItemDtoList.add(new TodoItemDto(todoItem.getAggregateId().getId(), todoItem.getName()));
            }
            PaginatedResult<TodoItemDto> todoItemDtos = new PaginatedResult<TodoItemDto>(todoItemDtoList, todoItems.getNumber(), todoItems.getSize(), todoItems.getTotalElements());
            return todoItemDtos;
        }

        return null;
    }
}

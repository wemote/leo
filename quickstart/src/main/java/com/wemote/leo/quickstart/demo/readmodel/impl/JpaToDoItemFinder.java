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

import com.wemote.leo.cqrs.query.PaginatedResult;
import com.wemote.leo.ddd.annotation.domain.FinderImpl;
import com.wemote.leo.ddd.support.domain.AggregateId;
import com.wemote.leo.quickstart.demo.readmodel.ToDoItemDto;
import com.wemote.leo.quickstart.demo.readmodel.ToDoItemFinder;
import com.wemote.leo.quickstart.demo.readmodel.ToDoItemQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@FinderImpl
public class JpaToDoItemFinder implements ToDoItemFinder {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ToDoItemDto find(AggregateId toDoItemId) {

        TypedQuery<ToDoItemDto> query = entityManager.createQuery(
                "SELECT o FROM ToDoItem o WHERE o.aggregateId = :aggregateId", ToDoItemDto.class);

        return query.setParameter("aggregateId", toDoItemId).getSingleResult();
    }

    @Override
    public PaginatedResult<ToDoItemDto> query(ToDoItemQuery toDoItemQuery) {
        return null;
    }
}

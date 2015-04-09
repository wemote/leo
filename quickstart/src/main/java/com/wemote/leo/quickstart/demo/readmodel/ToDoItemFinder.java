package com.wemote.leo.quickstart.demo.readmodel;

import com.wemote.leo.cqrs.query.PaginatedResult;
import com.wemote.leo.ddd.annotation.application.Finder;
import com.wemote.leo.ddd.support.domain.AggregateId;

/**
 * @author: jayon.xu@gmail.com
 */
@Finder
public interface TodoItemFinder {
    TodoItemDto find(AggregateId toDoItemId);

    PaginatedResult<TodoItemDto> query(TodoItemQuery toDoItemQuery);
}

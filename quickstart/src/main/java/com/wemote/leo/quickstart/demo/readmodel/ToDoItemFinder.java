package com.wemote.leo.quickstart.demo.readmodel;

import com.wemote.leo.cqrs.query.PaginatedResult;
import com.wemote.leo.ddd.annotation.application.Finder;
import com.wemote.leo.ddd.support.domain.AggregateId;
import org.springframework.data.domain.Pageable;

/**
 * @author: jayon.xu@gmail.com
 */
@Finder
public interface TodoItemFinder {

    TodoItemDto findByAggregateId(AggregateId todoItemId);

    PaginatedResult<TodoItemDto> findByTodoItemQuery(TodoItemQuery todoItemQuery, Pageable pageable);
}

package com.wemote.leo.quickstart.demo.domain;

import com.wemote.leo.ddd.annotation.domain.DomainRepository;
import com.wemote.leo.ddd.support.domain.AggregateId;

/**
 * @author: jayon.xu@gmail.com
 */
@DomainRepository
public interface TodoItemRepository {

    TodoItem get(AggregateId todoItemId);

    void add(TodoItem todoItem);
}

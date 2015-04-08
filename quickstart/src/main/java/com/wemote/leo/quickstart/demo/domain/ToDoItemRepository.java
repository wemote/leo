package com.wemote.leo.quickstart.demo.domain;

import com.wemote.leo.ddd.annotation.domain.DomainRepository;
import com.wemote.leo.ddd.support.domain.AggregateId;

/**
 * @author: jayon.xu@gmail.com
 */
@DomainRepository
public interface ToDoItemRepository {

    ToDoItem get(AggregateId toDoItemId);

    void add(ToDoItem toDoItem);
}

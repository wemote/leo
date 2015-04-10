package com.wemote.leo.quickstart.demo.readmodel;

import com.wemote.leo.ddd.infrastructure.support.repo.MyBaseRepository;
import com.wemote.leo.quickstart.demo.domain.TodoItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author: jayon.xu@gmail.com
 */
public interface TodoItemQueryRepository extends MyBaseRepository<TodoItem, Long> {

    Page<TodoItem> findByName(String name, Pageable pageable);
}

package com.wemote.leo.quickstart.demo.infrastructure.repo.jpa;

import com.wemote.leo.ddd.annotation.domain.DomainRepositoryImpl;
import com.wemote.leo.ddd.support.infrastructure.repo.jpa.GenericJpaRepository;
import com.wemote.leo.quickstart.demo.domain.TodoItem;
import com.wemote.leo.quickstart.demo.domain.TodoItemRepository;

/**
 * @author: jayon.xu@gmail.com
 */
@DomainRepositoryImpl
public class JpaTodoItemRepository extends GenericJpaRepository<TodoItem> implements TodoItemRepository {
}

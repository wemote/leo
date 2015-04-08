package com.wemote.leo.quickstart.demo.infrastructure.repo.jpa;

import com.wemote.leo.ddd.annotation.domain.DomainRepositoryImpl;
import com.wemote.leo.ddd.support.infrastructure.repo.jpa.GenericJpaRepository;
import com.wemote.leo.quickstart.demo.domain.ToDoItem;
import com.wemote.leo.quickstart.demo.domain.ToDoItemRepository;

/**
 * @author: jayon.xu@gmail.com
 */
@DomainRepositoryImpl
public class JpaToDoItemRepository extends GenericJpaRepository<ToDoItem> implements ToDoItemRepository {
}

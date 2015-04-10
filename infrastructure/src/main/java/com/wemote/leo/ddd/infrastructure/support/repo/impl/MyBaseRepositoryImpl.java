package com.wemote.leo.ddd.infrastructure.support.repo.impl;

import com.wemote.leo.ddd.infrastructure.support.repo.MyBaseRepository;
import com.wemote.leo.ddd.support.domain.AggregateId;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;

/**
 * @author: jayon.xu@gmail.com
 */
public class MyBaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyBaseRepository<T, ID> {

    private final EntityManager entityManager;

    public MyBaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);

        // Keep the EntityManager around to used from the newly introduced methods.
        this.entityManager = entityManager;
    }

    @Override
    public T findByAggregateId(AggregateId aggregateId) {
        TypedQuery<T> query = entityManager.createQuery(
                "SELECT o FROM " + getDomainClass().getName() + " o WHERE o.aggregateId = :aggregateId", getDomainClass());

        return query.setParameter("aggregateId", aggregateId).getSingleResult();
    }

}

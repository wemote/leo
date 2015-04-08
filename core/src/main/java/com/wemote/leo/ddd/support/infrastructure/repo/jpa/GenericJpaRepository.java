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
package com.wemote.leo.ddd.support.infrastructure.repo.jpa;

import com.wemote.leo.ddd.support.domain.AggregateId;
import com.wemote.leo.ddd.support.domain.BaseAggregateRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;

/**
 * @author jayon.xu@gmail.com
 */
public abstract class GenericJpaRepository<A extends BaseAggregateRoot> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(GenericJpaRepository.class);

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<A> clazz;

    @Inject
    private AutowireCapableBeanFactory spring;

    @SuppressWarnings("unchecked")
    public GenericJpaRepository() {
        this.clazz = ((Class<A>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public A get(AggregateId id) {

        TypedQuery<A> query = entityManager.createQuery(
                "SELECT o FROM " + clazz.getName() + " o WHERE o.aggregateId = :aggregateId", clazz);

        A aggregate = query.setParameter("aggregateId", id).getSingleResult();

        LOGGER.debug("Aggregate lock mode:[{}]", entityManager.getLockMode(aggregate));

        //lock to be sure when creating other objects based on values of this aggregate
        //A aggregate = entityManager.find(clazz, id, LockModeType.OPTIMISTIC);

        if (aggregate == null) {
            throw new RuntimeException("Aggregate " + clazz.getCanonicalName() + " id = " + id + " does not exist");
        }
        if (aggregate.isRemoved()) {
            throw new RuntimeException("Aggregate + " + id + " is removed.");
        }
        spring.autowireBean(aggregate);

        return aggregate;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void add(A aggregate) {
        if (entityManager.contains(aggregate)) {
            //locking Aggregate Root logically protects whole aggregate
            entityManager.lock(aggregate, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        } else {
            entityManager.persist(aggregate);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(AggregateId id) {
        A entity = get(id);
        //just flag
        entity.markAsRemoved();
    }
}

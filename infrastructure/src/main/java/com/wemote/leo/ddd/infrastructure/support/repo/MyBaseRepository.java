package com.wemote.leo.ddd.infrastructure.support.repo;

import com.wemote.leo.ddd.support.domain.AggregateId;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author: jayon.xu@gmail.com
 */
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID> {

    T findByAggregateId(AggregateId aggregateId);
}

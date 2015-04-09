package com.wemote.leo.quickstart.demo.domain;

import com.wemote.leo.ddd.annotation.domain.AggregateRoot;
import com.wemote.leo.ddd.support.domain.AggregateId;
import com.wemote.leo.ddd.support.domain.BaseAggregateRoot;

import javax.persistence.Entity;

/**
 * @author: jayon.xu@gmail.com
 */
@AggregateRoot
@Entity
public class TodoItem extends BaseAggregateRoot {

    private String name;

    public TodoItem(AggregateId todoItemId, String name) {
        this.aggregateId = todoItemId;
        this.name = name;
    }

    protected TodoItem() {
    }

    public String getName() {
        return name;
    }
}

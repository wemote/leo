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
public class ToDoItem extends BaseAggregateRoot {

    private String name;

    public ToDoItem(AggregateId toDoItemId, String name) {
        this.aggregateId = toDoItemId;
        this.name = name;
    }

    protected ToDoItem() {
    }

    public String getName() {
        return name;
    }
}

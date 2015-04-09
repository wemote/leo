package com.wemote.leo.quickstart.demo.readmodel;

import com.wemote.leo.ddd.support.domain.AggregateId;

/**
 * @author: jayon.xu@gmail.com
 */
public class TodoItemDto {

    private AggregateId toDoItemId;
    private String name;

    public AggregateId getToDoItemId() {
        return toDoItemId;
    }

    public TodoItemDto(AggregateId toDoItemId, String name) {
        this.toDoItemId = toDoItemId;
        this.name = name;
    }

    public void setToDoItemId(AggregateId toDoItemId) {
        this.toDoItemId = toDoItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

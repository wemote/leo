package com.wemote.leo.quickstart.demo.application.api;

import com.wemote.leo.cqrs.annotation.Command;
import com.wemote.leo.ddd.support.domain.AggregateId;

/**
 * @author: jayon.xu@gmail.com
 */
@Command
public class CreateTodoItemCommand {

    private final AggregateId todoItemId;
    private final String name;

    public CreateTodoItemCommand(AggregateId todoItemId, String name) {
        this.todoItemId = todoItemId;
        this.name = name;
    }

    public AggregateId getTodoItemId() {
        return todoItemId;
    }

    public String getName() {
        return name;
    }
}

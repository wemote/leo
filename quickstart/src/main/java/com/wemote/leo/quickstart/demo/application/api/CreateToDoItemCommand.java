package com.wemote.leo.quickstart.demo.application.api;

import com.wemote.leo.cqrs.annotation.Command;
import com.wemote.leo.ddd.support.domain.AggregateId;

/**
 * @author: jayon.xu@gmail.com
 */
@Command
public class CreateToDoItemCommand {

    private final AggregateId toDoItemId;
    private final String name;

    public CreateToDoItemCommand(AggregateId toDoItemId, String name) {
        this.toDoItemId = toDoItemId;
        this.name = name;
    }

    public AggregateId getToDoItemId() {
        return toDoItemId;
    }

    public String getName() {
        return name;
    }
}

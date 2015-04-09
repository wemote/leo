package com.wemote.leo.quickstart.demo.application.handler;

import com.wemote.leo.cqrs.annotation.CommandHandlerAnnotation;
import com.wemote.leo.cqrs.command.handler.CommandHandler;
import com.wemote.leo.quickstart.demo.application.api.CreateTodoItemCommand;
import com.wemote.leo.quickstart.demo.domain.TodoItem;
import com.wemote.leo.quickstart.demo.domain.TodoItemRepository;

import javax.inject.Inject;

/**
 * @author: jayon.xu@gmail.com
 */
@CommandHandlerAnnotation
public class CreateTodoItemCommandHandler implements CommandHandler<CreateTodoItemCommand, Void> {

    @Inject
    private TodoItemRepository todoItemRepository;

    @Override
    public Void handle(CreateTodoItemCommand command) {
        this.todoItemRepository.add(new TodoItem(command.getTodoItemId(), command.getName()));
        return null;
    }
}

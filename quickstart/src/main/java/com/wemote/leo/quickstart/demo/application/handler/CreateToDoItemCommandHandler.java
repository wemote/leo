package com.wemote.leo.quickstart.demo.application.handler;

import com.wemote.leo.cqrs.annotation.CommandHandlerAnnotation;
import com.wemote.leo.cqrs.command.handler.CommandHandler;
import com.wemote.leo.quickstart.demo.application.api.CreateToDoItemCommand;
import com.wemote.leo.quickstart.demo.domain.ToDoItem;
import com.wemote.leo.quickstart.demo.domain.ToDoItemRepository;

import javax.inject.Inject;

/**
 * @author: jayon.xu@gmail.com
 */
@CommandHandlerAnnotation
public class CreateToDoItemCommandHandler implements CommandHandler<CreateToDoItemCommand, Void> {

    @Inject
    private ToDoItemRepository toDoItemRepository;

    @Override
    public Void handle(CreateToDoItemCommand command) {
        this.toDoItemRepository.add(new ToDoItem(command.getToDoItemId(), command.getName()));
        return null;
    }
}

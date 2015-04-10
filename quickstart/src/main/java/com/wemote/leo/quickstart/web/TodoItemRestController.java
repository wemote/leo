package com.wemote.leo.quickstart.web;

import com.wemote.leo.cqrs.command.Gate;
import com.wemote.leo.cqrs.query.PaginatedResult;
import com.wemote.leo.ddd.support.domain.AggregateId;
import com.wemote.leo.quickstart.demo.application.api.CreateTodoItemCommand;
import com.wemote.leo.quickstart.demo.readmodel.TodoItemDto;
import com.wemote.leo.quickstart.demo.readmodel.TodoItemFinder;
import com.wemote.leo.quickstart.demo.readmodel.TodoItemQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * @author: jayon.xu@gmail.com
 */
@RestController
@RequestMapping(value = "/todoitems")
public class TodoItemRestController {

    @Inject
    private Gate gate;
    @Inject
    private TodoItemFinder todoItemFinder;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void add(@RequestBody TodoItemVo todoItemVo) {
        CreateTodoItemCommand createTodoItemCommand = new CreateTodoItemCommand(AggregateId.generate(), todoItemVo.getName());
        this.gate.dispatch(createTodoItemCommand);
    }

    @RequestMapping(value = "/{todoItemId}", method = RequestMethod.GET)
    public TodoItemDto get(@PathVariable("todoItemId") String todoItemId) {
        return this.todoItemFinder.findByAggregateId(new AggregateId(todoItemId));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public PaginatedResult<TodoItemDto> get(TodoItemQuery todoItemQuery) {
        PageRequest pageRequest = new PageRequest(todoItemQuery.getPage(), todoItemQuery.getSize());
        return this.todoItemFinder.findByTodoItemQuery(todoItemQuery, pageRequest);
    }
}

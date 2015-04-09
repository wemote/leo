package com.wemote.leo.quickstart.web;

import com.wemote.leo.cqrs.command.Gate;
import com.wemote.leo.ddd.support.domain.AggregateId;
import com.wemote.leo.quickstart.demo.application.api.CreateTodoItemCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * @author: jayon.xu@gmail.com
 */
@RestController
@RequestMapping(value = "/todoitems")
public class TodoItemRestController {

    @Inject
    private Gate gate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody TodoItemVo todoItemVo) {
        CreateTodoItemCommand createTodoItemCommand = new CreateTodoItemCommand(AggregateId.generate(), todoItemVo.getName());
        this.gate.dispatch(createTodoItemCommand);
    }
}

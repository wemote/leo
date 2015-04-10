package com.wemote.leo.quickstart.demo.readmodel;

/**
 * @author: jayon.xu@gmail.com
 */
public class TodoItemDto {

    private String todoItemId;
    private String name;

    public String getTodoItemId() {
        return todoItemId;
    }

    public TodoItemDto(String todoItemId, String name) {
        this.todoItemId = todoItemId;
        this.name = name;
    }

    public void setTodoItemId(String todoItemId) {
        this.todoItemId = todoItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

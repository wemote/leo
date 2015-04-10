package com.wemote.leo.quickstart.demo.readmodel;

/**
 * @author: jayon.xu@gmail.com
 */
public class TodoItemQuery {

    private String name;
    private int size;
    private int page;

    public TodoItemQuery() {
        this.size = 10;
        this.page = 1;
    }


    public TodoItemQuery(String name) {
        this();
        this.name = name;
    }

    public TodoItemQuery(String name, int size, int page) {
        this.name = name;
        this.size = size;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getPage() {
        return page;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

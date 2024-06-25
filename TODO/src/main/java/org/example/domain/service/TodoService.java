package org.example.domain.service;

import org.example.domain.model.Todo;
import org.example.domain.model.TodoList;
import org.example.domain.port.DataReader;
import org.example.domain.port.DataWriter;
import org.example.persistence.adapter.CSVReader;
import org.example.persistence.adapter.CSVWriter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TodoService {

    DataReader reader;
    DataWriter writer;

    public TodoService(DataReader reader, DataWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }


    public void addTodo(String todoName) {
        TodoList todos = reader.getAll();
        Todo todo = new Todo(todoName, LocalDateTime.now(), false);
        todos.addTodo(todo);
        writer.writeAll(todos);
    }

    public void deleteTodo(String todoName) {
        TodoList todos = reader.getAll();
        todos.removeTodo((todoName));
        writer.writeAll(todos);
    }

    public TodoList listTodo() {
        TodoList todos = reader.getAll();
        todos.sortTodoList();
        return todos;
    }

    public TodoList listNotDoneTodo() {
        TodoList todos = reader.getAll();
        todos = todos.getAllNotDone();
        todos.sortTodoList();
        return todos;
    }

    public TodoList listDoneTodo() {
        TodoList todos = reader.getAll();
        todos = todos.getAllDone();
        todos.sortTodoList();
        return todos;
    }

    public void setDoneTodo(String todoName) {
        TodoList todos = reader.getAll();
        Todo todo = todos.getTodoByName(todoName);
        if(todo != null) {
            todos.getTodoByName(todoName).setDone();
        }
        writer.writeAll(todos);
    }

    public void setNotDoneTodo(String todoName) {
        TodoList todos = reader.getAll();
        Todo todo = todos.getTodoByName(todoName);
        if(todo != null) {
            todos.getTodoByName(todoName).setNotDone();
        }
        writer.writeAll(todos);
    }

}

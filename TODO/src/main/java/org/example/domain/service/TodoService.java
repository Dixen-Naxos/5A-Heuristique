package org.example.domain.service;

import org.example.domain.model.Todo;
import org.example.domain.model.TodoList;
import org.example.domain.port.DataReader;
import org.example.domain.port.DataWriter;
import org.example.persistence.adapter.CSVReader;
import org.example.persistence.adapter.CSVWriter;

import java.time.LocalDate;
import java.util.List;

public class TodoService {

    static String filename = "resources/todo.csv";
    static DataReader reader = new CSVReader(filename);
    static DataWriter writer = new CSVWriter(filename);


    public void addTodo(String todoName) {
        TodoList todos = reader.getAll();
        Todo todo = new Todo(todoName, LocalDate.now(), false);
        todos.addTodo(todo);
        writer.writeAll(todos);
    }

    public void deleteTodo(String todoName) {
        TodoList todos = reader.getAll();
        todos.removeTodo((todoName));
        writer.writeAll(todos);
    }

    public TodoList listTodo() {
        return reader.getAll();
    }

    public TodoList listNotDoneTodo() {
        TodoList todos = reader.getAll();
        return todos;
    }

    public TodoList listDoneTodo() {
        TodoList todos = reader.getAll();
        return todos;
    }

    public void setDoneTodo(String todoName) {
        TodoList todos = reader.getAll();
        todos.getTodoByName(todoName).setDone();
        writer.writeAll(todos);
    }

    public void setNotDoneTodo(String todoName) {
        TodoList todos = reader.getAll();
        todos.getTodoByName(todoName).setNotDone();
        writer.writeAll(todos);
    }

}

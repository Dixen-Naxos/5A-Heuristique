package org.example.domain.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class TodoList {
    private List<Todo> todos;

    public TodoList() {
        this.todos = new ArrayList<Todo>();
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public void removeTodo(String todoName) {
        todos.removeIf(todo -> todo.getName().equals(todoName));
    }

    public Todo getTodoByName(String name) {
        for (Todo todo : todos) {
            if (todo.getName().equals(name)) {
                return todo;
            }
        }
        return null;
    }

    public TodoList getAllDone() {
        TodoList newTodoList = new TodoList();
        for (Todo todo : todos) {
            if(todo.isDone()) {
                newTodoList.addTodo(todo);
            }
        }
        return newTodoList;
    }

    public TodoList getAllNotDone() {
        TodoList newTodoList = new TodoList();
        for (Todo todo : todos) {
            if(!todo.isDone()) {
                newTodoList.addTodo(todo);
            }
        }
        return newTodoList;
    }

    public void sortTodoList() {
        todos.sort((t1, t2) -> t2.getCreationDate().compareTo(t1.getCreationDate()));
    }
}

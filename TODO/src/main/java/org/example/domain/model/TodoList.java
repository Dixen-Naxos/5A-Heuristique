package org.example.domain.model;
import java.util.ArrayList;
import java.util.List;

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
}

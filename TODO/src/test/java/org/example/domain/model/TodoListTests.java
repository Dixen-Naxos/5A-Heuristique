package org.example.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTests {

    private TodoList todoList;

    @BeforeEach
    public void setUp() {
        todoList = new TodoList();
    }

    @Test
    void testAddAndGetTodo() {
        Todo todo = new Todo("Test Task", LocalDateTime.now(), false);

        todoList.addTodo(todo);

        assertNotNull(todoList.getTodoByName("Test Task"));
    }

    @Test
    void testRemoveTodo() {
        Todo todo = new Todo("Test Task", LocalDateTime.now(), false);
        todoList.addTodo(todo);

        todoList.removeTodo("Test Task");

        assertNull(todoList.getTodoByName("Test Task"));
    }

    @Test
    void testGetAllDone() {
        Todo todo1 = new Todo("Done Task", LocalDateTime.now(), true);
        Todo todo2 = new Todo("Not Done Task", LocalDateTime.now(), false);
        todoList.addTodo(todo1);
        todoList.addTodo(todo2);

        TodoList doneTodos = todoList.getAllDone();

        assertTrue(doneTodos.getTodos().contains(todo1));
        assertFalse(doneTodos.getTodos().contains(todo2));
    }

    @Test
    void testGetAllNotDone() {
        Todo todo1 = new Todo("Done Task", LocalDateTime.now(), true);
        Todo todo2 = new Todo("Not Done Task", LocalDateTime.now(), false);
        todoList.addTodo(todo1);
        todoList.addTodo(todo2);

        TodoList notDoneTodos = todoList.getAllNotDone();

        assertTrue(notDoneTodos.getTodos().contains(todo2));
        assertFalse(notDoneTodos.getTodos().contains(todo1));
    }

    @Test
    void testSortTodoList() {
        Todo todo1 = new Todo("A", LocalDateTime.of(2024,  Month.JUNE, 24,6,30,40,50000), false);
        Todo todo2 = new Todo("B", LocalDateTime.of(2024, Month.JUNE,23,6,30,40,50000), false);
        todoList.addTodo(todo1);
        todoList.addTodo(todo2);

        todoList.sortTodoList();

        assertEquals(todo2, todoList.getTodos().get(1));
        assertEquals(todo1, todoList.getTodos().get(0));
    }
}

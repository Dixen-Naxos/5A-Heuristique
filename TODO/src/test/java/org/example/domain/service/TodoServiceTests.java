package org.example.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.example.domain.model.Todo;
import org.example.domain.model.TodoList;
import org.example.domain.port.DataReader;
import org.example.domain.port.DataWriter;
import org.example.persistence.adapter.CSVReader;
import org.example.persistence.adapter.CSVWriter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TodoServiceTests {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private DataReader reader;

    @Mock
    private DataWriter writer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteTodo() {
        String todoName = "Test Task";
        TodoList todoList = new TodoList();
        todoList.addTodo(new Todo(todoName, LocalDateTime.now(), false));
        when(reader.getAll()).thenReturn(todoList);

        todoService.deleteTodo(todoName);

        verify(writer).writeAll(todoList);
    }

    @Test
    void testListTodo() {

        TodoList todoList = new TodoList();
        todoList.addTodo(new Todo("Task 1", LocalDateTime.now(), false));
        todoList.addTodo(new Todo("Task 2", LocalDateTime.now(), true));
        when(reader.getAll()).thenReturn(todoList);

        TodoList result = todoService.listTodo();

        assertEquals(todoList.getTodos().size(), result.getTodos().size());
    }

    @Test
    void testListNotDoneTodo() {

        TodoList todoList = new TodoList();
        todoList.addTodo(new Todo("Task 1", LocalDateTime.now(), false));
        todoList.addTodo(new Todo("Task 2", LocalDateTime.now(), true));
        when(reader.getAll()).thenReturn(todoList);

        TodoList result = todoService.listNotDoneTodo();

        assertEquals(1, result.getTodos().size());
    }

    @Test
    void testListDoneTodo() {

        TodoList todoList = new TodoList();
        todoList.addTodo(new Todo("Task 1", LocalDateTime.now(), false));
        todoList.addTodo(new Todo("Task 2", LocalDateTime.now(), true));
        when(reader.getAll()).thenReturn(todoList);

        TodoList result = todoService.listDoneTodo();

        assertEquals(1, result.getTodos().size());
    }

    @Test
    void testSetDoneTodo() {
        String todoName = "Test Task";
        TodoList todoList = new TodoList();
        todoList.addTodo(new Todo(todoName, LocalDateTime.now(), false));
        when(reader.getAll()).thenReturn(todoList);

        todoService.setDoneTodo(todoName);

        verify(writer).writeAll(todoList);
    }

    @Test
    void testSetNotDoneTodo() {
        String todoName = "Test Task";
        TodoList todoList = new TodoList();
        todoList.addTodo(new Todo(todoName, LocalDateTime.now(), false));
        when(reader.getAll()).thenReturn(todoList);

        todoService.setNotDoneTodo(todoName);

        verify(writer).writeAll(todoList);
    }
}

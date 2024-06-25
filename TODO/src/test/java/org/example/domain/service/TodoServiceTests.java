package org.example.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.example.domain.model.Todo;
import org.example.domain.port.DataReader;
import org.example.domain.port.DataWriter;

import java.time.LocalDate;
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
        List<Todo> todos = List.of(new Todo(todoName, LocalDate.now(), false));
        when(reader.getAll()).thenReturn(todos);

        todoService.deleteTodo(todoName);

        verify(writer).writeAll(todos); // Assuming deletion doesn't change the list size
    }

    @Test
    void testListTodo() {
        List<Todo> todos = List.of(new Todo("Task 1", LocalDate.now(), false),
                new Todo("Task 2", LocalDate.now(), true));

        when(reader.getAll()).thenReturn(todos);

        todoService.listTodo();

        verify(writer).writeAll(todos);
    }

    @Test
    void testListNotDoneTodo() {
        List<Todo> todos = List.of(new Todo("Task 1", LocalDate.now(), false),
                new Todo("Task 2", LocalDate.now(), true));

        when(reader.getAll()).thenReturn(todos);

        todoService.listNotDoneTodo();

        verify(writer).writeAll(List.of(todos.get(0))); // Only the first task is not done
    }

    @Test
    void testListDoneTodo() {
        List<Todo> todos = List.of(new Todo("Task 1", LocalDate.now(), false),
                new Todo("Task 2", LocalDate.now(), true));

        when(reader.getAll()).thenReturn(todos);

        todoService.listDoneTodo();

        verify(writer).writeAll(List.of(todos.get(1))); // Only the second task is done
    }

    @Test
    void testSetDoneTodo() {
        String todoName = "Test Task";
        List<Todo> todos = List.of(new Todo(todoName, LocalDate.now(), false));
        when(reader.getAll()).thenReturn(todos);

        todoService.setDoneTodo(todoName);

        verify(writer).writeAll(todos); // Assuming setting done doesn't change the list
    }

    @Test
    void testSetNotDoneTodo() {
        String todoName = "Test Task";
        List<Todo> todos = List.of(new Todo(todoName, LocalDate.now(), false));
        when(reader.getAll()).thenReturn(todos);

        todoService.setNotDoneTodo(todoName);

        verify(writer).writeAll(todos); // Assuming setting not done doesn't change the list
    }
}

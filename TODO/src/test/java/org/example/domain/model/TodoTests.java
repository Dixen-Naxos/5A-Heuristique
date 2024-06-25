package org.example.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TodoTests {

    @Test
    void testConstructorAndGetterMethods() {
        String expectedName = "Test Task";
        LocalDateTime expectedCreationDate = LocalDateTime.now();
        boolean expectedDone = false;

        Todo todo = new Todo(expectedName, expectedCreationDate, expectedDone);

        assertEquals(expectedName, todo.getName());
        assertEquals(expectedCreationDate, todo.getCreationDate());
        assertFalse(todo.isDone());
    }
}

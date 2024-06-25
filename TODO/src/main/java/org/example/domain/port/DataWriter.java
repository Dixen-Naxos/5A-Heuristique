package org.example.domain.port;

import org.example.domain.model.TodoList;

public interface DataWriter {
    void writeAll(TodoList todos);
}

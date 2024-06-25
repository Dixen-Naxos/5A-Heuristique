package org.example.domain.port;

import org.example.domain.model.TodoList;

public interface DataReader {

    TodoList getAll();

    TodoList getAllDone();

    TodoList getAllNotDone();
}

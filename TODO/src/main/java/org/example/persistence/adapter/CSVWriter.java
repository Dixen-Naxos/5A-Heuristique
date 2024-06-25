package org.example.persistence.adapter;

import org.example.domain.model.Todo;
import org.example.domain.model.TodoList;
import org.example.domain.port.DataWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter implements DataWriter {
    ;
    String fileName;

    public CSVWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeAll(TodoList todos) {
        try (FileWriter writer = new FileWriter(this.fileName, false)) {
            for (Todo todo : todos.getTodos()) {
                writer.write(todo.getName()+";"+todo.getCreationDate()+";"+todo.isDone()+ "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.example.persistence.adapter;

import org.example.domain.model.Todo;
import org.example.domain.model.TodoList;
import org.example.domain.port.DataReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class CSVReader implements DataReader {

    String fileName;

    public CSVReader(String fileName) {
        this.fileName = fileName;
    }

    public TodoList getAll() {
        TodoList todos = new TodoList();
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 3) {
                    throw new IOException("Invalid CSV file");
                }

                String name = parts[0];
                LocalDate creationDate = LocalDate.parse(parts[1]);
                boolean done = Boolean.parseBoolean(parts[2]);

                todos.addTodo(new Todo(name, creationDate, done));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public TodoList getAllDone() {
        TodoList todos = new TodoList();
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 3) {
                    throw new IOException("Invalid CSV file");
                }

                String name = parts[0];
                LocalDate creationDate = LocalDate.parse(parts[1]);
                boolean done = Boolean.parseBoolean(parts[2]);

                if (done) {
                    todos.addTodo(new Todo(name, creationDate, done));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return todos;
    }


    public TodoList getAllNotDone() {
        TodoList todos = new TodoList();
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 3) {
                    throw new IOException("Invalid CSV file");
                }

                String name = parts[0];
                LocalDate creationDate = LocalDate.parse(parts[1]);
                boolean done = Boolean.parseBoolean(parts[2]);

                if (!done) {
                    todos.addTodo(new Todo(name, creationDate, done));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return todos;
    }

}

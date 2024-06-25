package org.example.domain.model;

import java.time.LocalDate;

public class Todo {

    String name;
    LocalDate creationDate;
    boolean done;

    public Todo(String name, LocalDate creationDate, boolean done) {
        this.name = name;
        this.creationDate = creationDate;
        this.done = done;
    }


    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isDone() {
        return done;
    }
}

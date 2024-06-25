package org.example.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {

    String name;
    LocalDateTime creationDate;
    boolean done;

    public Todo(String name, LocalDateTime creationDate, boolean done) {
        this.name = name;
        this.creationDate = creationDate;
        this.done = done;
    }


    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }

    public void setNotDone() {
        this.done = false;
    }
}

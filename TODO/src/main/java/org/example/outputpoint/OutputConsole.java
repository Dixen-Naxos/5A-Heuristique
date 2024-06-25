package org.example.outputpoint;

import org.example.domain.model.TodoList;

import java.time.Duration;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class OutputConsole {

    public static void outputList(TodoList todoList) {

        DecimalFormat decFormat = new DecimalFormat("00");
        LocalDateTime currentDateTime = LocalDateTime.now();


        for (int i = 1; i < todoList.getTodos().size(); i++) {

            Duration duration = Duration.between(todoList.getTodos().get(i).getCreationDate(), currentDateTime);

            System.out.print("[" + decFormat.format(i) + "]");
            System.out.print("[" + (todoList.getTodos().get(i).isDone() ? "X" : " ") + "]");
            System.out.print(" " + todoList.getTodos().get(i).getName() + " ");
            System.out.print("(" + getDurationAsString(duration) + ")");
        }
    }

    private static String getDurationAsString(Duration duration) {
        if (duration.toMinutes() < 60) {
            return duration.toMinutes() + "";
        } else if (duration.toHours() < 24) {
            return duration.toHours() + "";
        }
        return duration.toDays() + "";
    }

    public static void outputEnd() {
        System.out.println("done.");
    }
}

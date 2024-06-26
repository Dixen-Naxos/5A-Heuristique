package org.example.outputpoint;

import org.example.domain.model.Todo;
import org.example.domain.model.TodoList;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFile {

    static String fileName = "resources/report.md";

    public static void outputDoneList(TodoList doneList) {

        try (FileWriter writer = new FileWriter(fileName, false)) {

            writer.write("# Report\n");
            writer.write("## Task done:\n");

            for (int i = 0; i < doneList.getTodos().size(); i++) {
                Todo todo = doneList.getTodos().get(i);
                writer.write("- "+todo.getName()+" ("+todo.getCreationDate().getYear()+"-"+todo.getCreationDate().getMonth()+"-"+ todo.getCreationDate().getDayOfMonth()+")\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputNotDoneList(TodoList notDoneList) {

        try (FileWriter writer = new FileWriter(fileName, false)) {

            writer.write("# Report\n");
            writer.write("## Task not done:\n");

            for (int i = 0; i < notDoneList.getTodos().size(); i++) {
                Todo todo = notDoneList.getTodos().get(i);
                writer.write("- "+todo.getName()+" ("+todo.getCreationDate().getYear()+"-"+todo.getCreationDate().getMonth()+"-"+ todo.getCreationDate().getDayOfMonth()+")\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

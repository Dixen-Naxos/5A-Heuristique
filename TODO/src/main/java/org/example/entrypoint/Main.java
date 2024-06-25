package org.example.entrypoint;

import org.example.domain.model.TodoList;
import org.example.domain.port.DataReader;
import org.example.domain.port.DataWriter;
import org.example.domain.service.TodoService;
import org.example.outputpoint.OutputConsole;
import org.example.outputpoint.OutputFile;
import org.example.persistence.adapter.CSVReader;
import org.example.persistence.adapter.CSVWriter;

public class Main {

    static String filename = "resources/todo.csv";
    static DataReader reader = new CSVReader(filename);
    static DataWriter writer = new CSVWriter(filename);
    static TodoService todoService = new TodoService(reader, writer);

    public static void main(String[] args) {


        String commandName = args[0];
        String argument = args[1];
        CommandEnum command = CommandEnum.valueOf(commandName);

        switch (command) {
            case LIST:
                list();
                break;
            case ADD:
                add(argument);
                break;
            case DELETE:
                delete(argument);
                break;
            case REPORT:
                ReportEnum reportType = ReportEnum.valueOf(argument);
                report(reportType);
                break;
            case DONE:
                done(argument);
                break;
            case NOTDONE:
                notdone(argument);
                break;
        }
    }

    private static void list() {
        TodoList todoList = todoService.listTodo();
        OutputConsole.outputList(todoList);
    }

    private static void add(String name) {
        todoService.addTodo(name);
        OutputConsole.outputEnd();
    }

    private static void delete(String name) {
        todoService.deleteTodo(name);
        OutputConsole.outputEnd();
    }

    private static void report(ReportEnum reportType) {

        TodoList todoList;

        switch (reportType) {
            case ReportEnum.DONE:
                todoList = todoService.listDoneTodo();
                OutputFile.outputDoneList(todoList);
                break;
            case ReportEnum.NOTDONE:
                todoList = todoService.listNotDoneTodo();
                OutputFile.outputNotDoneList(todoList);
                break;
        }

        OutputConsole.outputEnd();
    }

    private static void done(String name) {
        todoService.setDoneTodo(name);
        OutputConsole.outputEnd();
    }

    private static void notdone(String name) {
        todoService.setDoneTodo(name);
        OutputConsole.outputEnd();
    }
}
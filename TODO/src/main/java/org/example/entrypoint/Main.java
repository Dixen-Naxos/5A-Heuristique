package org.example.entrypoint;

import org.example.domain.service.TodoService;

public class Main {

    static TodoService todoService = new TodoService();

    public static void main(String[] args) {

        CommandEnum command = CommandEnum.valueOf(args[0]);

        switch (command) {
            case LIST:
                list();
                break;
            case ADD:
                add(args[1]);
                break;
            case DELETE:
                delete(args[1]);
                break;
            case REPORT:
                report(args[1]);
                break;
            case DONE:
                done(args[1]);
                break;
            case NOTDONE:
                notdone(args[1]);
                break;
        }
    }

    private static void list() {

    }

    private static void add(String arg) {

    }

    private static void delete(String arg) {

    }

    private static void report(String arg) {

    }

    private static void done(String arg) {

    }

    private static void notdone(String arg) {

    }
}
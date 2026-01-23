package app;

import main.java.domain.Status;
import main.java.services.TaskService;
import main.java.cli.CommandLoop;

public class Main {

    public static void main (String[] args) {
       TaskService taskService = new TaskService();
       CommandLoop commandLoop = new CommandLoop(taskService);

       commandLoop.displayMenu();

    }
}
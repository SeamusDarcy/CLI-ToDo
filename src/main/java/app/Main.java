package app;

import domain.Status;
import services.TaskService;
import cli.CommandLoop;

public class Main {

    public static void main (String[] args) {
       TaskService taskService = new TaskService();
       CommandLoop commandLoop = new CommandLoop(taskService);

       commandLoop.displayMenu();

    }
}
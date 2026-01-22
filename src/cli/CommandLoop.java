package cli;

import services.TaskService;

import java.util.Scanner;

public class CommandLoop {
    private boolean isRunning = true;
    int choice = 0;

    private final TaskService taskService;
    Scanner scanner = new Scanner(System.in);


    public CommandLoop (TaskService taskService) {
        this.taskService = taskService;
    }



    public void displayMenu() {
        while(isRunning){
            System.out.println("-----------------------");
            System.out.println("Welcome to To-Do CLI");
            System.out.println("-----------------------");
            System.out.println("1 : add a new task");
            System.out.println("2 : delete a task");
            System.out.println("3 : Change Status of Task");
            System.out.println("4 : View tasks");
            System.out.println("5 : Exit");
            while (true) {
                System.out.print("Enter Choice : ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Please enter a valid choice");
                    scanner.nextLine();
                }

            }
            switch (choice) {
                case 1 -> {
                    String title;
                    while(true){
                        System.out.println("Enter Task Title");
                        title = scanner.nextLine().trim();
                        if(title.isEmpty()){
                            System.out.println("Please enter a valid Title");
                            continue;
                        }
                        break;
                    }
                    taskService.createTask(title);
                    System.out.println("Task Created");
                }
                case 2 -> {
                    int id;
                    while(true){
                        System.out.print("Enter Task ID to delete : ");
                        if (scanner.hasNextInt()){
                            id = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Please enter a valid Number");
                            scanner.nextLine();
                        }
                    }
                    boolean deleted = taskService.deleteTask(id);
                    if(deleted){
                        System.out.println("Task Deleted");
                    } else {
                        System.out.println("Could not find task");
                    }
                }


            }


        }


    }

}



package services;

import domain.Status;
import domain.Task;

import java.util.ArrayList;

public class TaskService {
    private int idCounter = 1;
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskService() {

    }

    public Task createTask(String title) {
        Task task = new Task(title, idCounter++);
        tasks.add(task);
        return task;

    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(t -> t.getID() == id);
    }


    public void changeStaus(int id, Status newStatus) {
        for (Task t : tasks) {
            if (t.getID() == id) {
                switch (newStatus) {
                    case TODO -> t.setTaskStatus(Status.TODO);
                    case IN_PROGRESS -> t.setTaskStatus(Status.IN_PROGRESS);
                    case DONE -> t.setTaskStatus(Status.DONE);
                    default -> System.out.println("Enter a Valid Input");
                }
                return;
            }
        }
        System.out.println("Task not Found");
    }

    public void listTasks() {
        System.out.println();
        System.out.println("-------------");
        System.out.println("To-Do");
        System.out.println("-------------");
        for (Task task : tasks) {
            if (task.getTaskStatus() == Status.TODO) {
                System.out.println(" -" + task.getTitle());
            }
        }
        System.out.println();
        System.out.println("-------------");
        System.out.println("In Progress");
        System.out.println("-------------");
        for (Task task : tasks) {
            if (task.getTaskStatus() == Status.IN_PROGRESS) {
                System.out.println(" -" + task.getTitle());
            }
        }
        System.out.println();
        System.out.println("-------------");
        System.out.println("Done");
        System.out.println("-------------");
        for (Task task : tasks) {
            if (task.getTaskStatus() == Status.DONE) {
                System.out.println(" -" + task.getTitle());
            }


        }
    }
}
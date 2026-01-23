package main.java.domain;

public class Task {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title != null && !title.isEmpty()){
            this.title = title;
        }
        else {
            System.out.println("Enter valid title");
        }
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getId() {
        return ID;
    }

    private String title;
    private Status taskStatus = Status.TODO;
    private final int ID;

    public Task(String title, int ID) {
        this.title = title;
        this.ID = ID;

    }





}

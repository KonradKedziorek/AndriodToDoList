package com.example.secondandroidapp;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskStorage {

    private static class LazyHolder{
        static final TaskStorage INSTANCE = new TaskStorage();
    }

    private List<Task> tasks = new ArrayList<Task>();

    private TaskStorage(){
        for(int i=0;i<100;i++){
            tasks.add(new Task());
        }
    }

    public static TaskStorage getInstance() { return LazyHolder.INSTANCE; }
    public List<Task> getTasks() { return tasks; }
    public Task getTask(UUID id){
        for (Task task:tasks) {
            if(task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

}

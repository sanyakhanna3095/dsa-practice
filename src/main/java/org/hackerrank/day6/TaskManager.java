package org.hackerrank.day6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TaskManager {
    private static class Task implements Comparable<Task>{
        int id;
        int taskId;
        int priority;

        public Task(int id, int taskId, int priority){
            this.id=id;
            this.taskId=taskId;
            this.priority=priority;
        }

        @Override
        public int compareTo(Task o) {
            if(this.priority!=o.priority){
                return Integer.compare(o.priority, this.priority);
            }
            return Integer.compare(o.taskId, this.taskId);
        }
    }
    private final TreeMap<Task, Integer> sortedTasks;
    private final Map<Integer, Task> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        sortedTasks = new TreeMap<>();
        taskMap = new HashMap<>();
        for (List<Integer> task : tasks) {
            int id = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            add(id, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task=new Task(userId, taskId, priority);
        sortedTasks.put(task, userId);
        taskMap.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        Task task=taskMap.get(taskId);
        if (task != null) {
            sortedTasks.remove(task);
            task.priority = newPriority;
            sortedTasks.put(task, task.id);
        }
    }

    public void rmv(int taskId) {
        Task task=taskMap.get(taskId);
        if(task!=null){
            sortedTasks.remove(task);
            taskMap.remove(taskId);
        }
    }

    public int execTop() {
        if(sortedTasks.isEmpty()){
            return -1;
        }
        Task task=sortedTasks.firstKey();
        sortedTasks.remove(task);
        taskMap.remove(task.taskId);
        return task.id;
    }

}

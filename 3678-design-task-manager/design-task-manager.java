class TaskManager {

    Map<Integer, Integer> taskPriorityMap = new HashMap<>();
    Map<Integer, Integer> taskUserMap = new HashMap<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] == a[2] ? b[1] - a[1] : b[2] - a[2]);

    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> task: tasks){
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            taskPriorityMap.put(taskId, priority);
            taskUserMap.put(taskId, userId);
            pq.add(new int[]{userId, taskId, priority});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskPriorityMap.put(taskId, priority);
        taskUserMap.put(taskId, userId);
        pq.add(new int[]{userId, taskId, priority});
    }
    
    public void edit(int taskId, int newPriority) {
        int userId = taskUserMap.get(taskId);
        taskPriorityMap.put(taskId, newPriority);
        pq.add(new int[]{userId, taskId, newPriority});
    }
    
    public void rmv(int taskId) {
        taskPriorityMap.remove(taskId);
        taskUserMap.remove(taskId);
    }
    
    public int execTop() {
        int[] task = pq.peek();

        while(pq.size() > 0  && (taskPriorityMap.get(task[1]) == null 
                                || taskPriorityMap.get(task[1]) != task[2] 
                                || taskUserMap.get(task[1]) != task[0]) ){
            pq.poll();
            task = pq.peek();
        }

        if(pq.size() == 0){
            return -1;
        }

        pq.poll();
        taskPriorityMap.remove(task[1]);
        taskUserMap.remove(task[1]);
        
        return task[0];
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
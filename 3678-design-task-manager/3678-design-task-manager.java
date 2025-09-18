class TaskManager {
    // Task info: taskId -> [userId, priority]
    private Map<Integer, int[]> taskMap;
    // Max-heap: highest priority first, if tie → highest taskId
    private PriorityQueue<int[]> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1]; // higher priority first
            return b[0] - a[0]; // if tie, higher taskId first
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            pq.offer(new int[]{taskId, priority});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        pq.offer(new int[]{taskId, priority});
    }
    
    public void edit(int taskId, int newPriority) {
        int[] info = taskMap.get(taskId);
        info[1] = newPriority;
        taskMap.put(taskId, info);
        pq.offer(new int[]{taskId, newPriority}); // lazy update
    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy removal (heap still has old entry)
    }
    
    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int taskId = top[0], priority = top[1];

            if (taskMap.containsKey(taskId) && taskMap.get(taskId)[1] == priority) {
                int userId = taskMap.get(taskId)[0];
                taskMap.remove(taskId); // remove after execution
                return userId;
            }
            // otherwise skip outdated entry
        }
        return -1; // no tasks available
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